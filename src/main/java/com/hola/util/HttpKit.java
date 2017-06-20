package com.hola.util;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.zip.GZIPInputStream;
/**
 * 自定义调用接口类  使用原生的java net 
 * 测试比封住的jsoup/httpclient快,但是数据处理还是靠他们
 * @author Dougest 2017年6月6日    下午8:20:04
 *
 */
public final class HttpKit {
	//加密请求时使用
    private static final SSLSocketFactory SSL_SOCKET_FACTORY = initSSLSocketFactory();
    //host认证,和ssl搭配使用
    private static final HostnameVerifier VERIFIER = (a, b) -> Boolean.TRUE;
    
    private static SSLSocketFactory initSSLSocketFactory() {
        try {
        	//根据
            SSLContext context = SSLContext.getInstance("TLS", "SunJSSE");
            context.init(null, null, new SecureRandom());
            return context.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final ThreadLocal<Proxy> PROXY = new ThreadLocal<>();

    public static void setProxy(Proxy proxy) {
        PROXY.set(proxy);
    }

    public static void removeProxy() {
        PROXY.remove();
    }

    public static final Function<HttpURLConnection, InputStream> ToStream = conn -> {
        try {
            String contentEncoding = conn.getContentEncoding();
            return "gzip".equals(contentEncoding) ? new GZIPInputStream(conn.getInputStream()) : conn.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    private HttpKit() {
        throw new RuntimeException("do not create HttpKit instance");
    }

    public static Builder get(String url) {
        return new Builder().get(url);
    }

    public static String get(String url, Parameter header, Parameter urlParameter) {
        return get(url).header(header).urlParameter(urlParameter).asString();
    }

    public static Builder post(String url) {
        return new Builder().post(url);
    }

    public static String post(String url, String body) {
        return post(url).body(body).asString();
    }

    public static String post(String url, Parameter header, String body) {
        return post(url).header(header).body(body).asString();
    }

    public static void download(String url, Parameter header, Parameter urlParameter, final File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new RuntimeException("File \'" + file + "\' exists but is a directory");
            } else if (!file.canWrite()) {
                throw new RuntimeException("File \'" + file + "\' cannot be written to");
            }
        } else {
            File parent = file.getParentFile();
            if (parent != null && !parent.mkdirs() && !parent.isDirectory()) {
                throw new RuntimeException("Directory \'" + parent + "\' could not be created");
            }
        }
        get(url).header(header).urlParameter(urlParameter).build(conn->{
            try (InputStream input = ToStream.apply(conn)) {
                try (FileOutputStream output = new FileOutputStream(file, false)) {
                    copy(input, output, new byte[4096]);
                    output.flush();
                }
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static String upload(String url, Parameter header, Parameter body, Map<String, File> files) {
        return post(url).header(header).before(conn->{
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------10f7cef2def646dc83b0dbd594a197eb");
        }).after(conn->{
            try (OutputStream os = conn.getOutputStream(); DataOutputStream dos = new DataOutputStream(os)) {
                byte[] buffer = new byte[4096];
                for (Iterator<String> it = files.keySet().iterator(); it.hasNext(); ) {
                    String name = it.next();
                    File file = files.get(name);
                    dos.writeBytes("------------10f7cef2def646dc83b0dbd594a197eb\r\n");
                    dos.writeBytes("Content-Disposition: form-data;name=\"" + name + "\";filename=\"" + file.getName() + "\"\r\n");
                    dos.writeBytes("Content-Type:application/octet-stream\r\n");
                    dos.writeBytes("\r\n");
                    FileInputStream input = new FileInputStream(file);
                    try {
                        copy(input, dos, buffer);
                    } finally {
                        if (input != null) {
                            input.close();
                        }
                    }
                    dos.writeBytes("\r\n");
                }
                if (body != null) {
                    for (Iterator<String> it = body.iterator(); it.hasNext(); ) {
                        String name = it.next();
                        String value = body.get(name);
                        dos.writeBytes("------------10f7cef2def646dc83b0dbd594a197eb\r\n");
                        dos.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"\r\n");
                        dos.writeBytes("\r\n");
                        dos.writeBytes(value);
                        dos.writeBytes("\r\n");
                    }
                }
                dos.writeBytes("------------10f7cef2def646dc83b0dbd594a197eb--\r\n");
                dos.writeBytes("\r\n");
                dos.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).asString();
    }

    public static String upload(String url, Parameter header, String name, File file) {
        Map<String, File> map = new HashMap<>(1);
        map.put(name, file);
        return upload(url, header, null, map);
    }

    private static long copy(InputStream input, OutputStream output, byte[] buffer) throws IOException {
        long count = 0L;
        for (int n; -1 != (n = input.read(buffer)); count += (long) n) {
            output.write(buffer, 0, n);
        }
        return count;
    }

    private static HttpURLConnection buildHttpConnection(Builder builder) throws Exception {
        URL _url = new URL(builder.buildUrlParameters());
        HttpURLConnection conn;
        Proxy proxy = PROXY.get();
        if (proxy != null) {
            conn = (HttpURLConnection) _url.openConnection(proxy);
            conn.setConnectTimeout(60000);
            conn.setReadTimeout(60000);
        } else {
            conn = (HttpURLConnection) _url.openConnection();
            conn.setConnectTimeout(20000);
            conn.setReadTimeout(20000);
        }
        if (conn instanceof HttpsURLConnection) {
            ((HttpsURLConnection) conn).setSSLSocketFactory(SSL_SOCKET_FACTORY);
            ((HttpsURLConnection) conn).setHostnameVerifier(VERIFIER);
        }
        conn.setRequestMethod(builder.method);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        if (builder.header != null) {
            for (Iterator<String> i = builder.header.iterator(); i.hasNext(); ) {
                String key = i.next();
                conn.setRequestProperty(key, builder.header.get(key));
            }
        }
        return conn;
    }

    public static <R> R execute(Builder builder,Function<HttpURLConnection,R> handler){
        HttpURLConnection conn = null;
        try {
            conn = buildHttpConnection(builder);
            if (builder.before != null) {
                builder.before.accept(conn);
            }
            conn.connect();
            if ("POST".equals(builder.method) && builder.body != null) {
                try (OutputStream e = conn.getOutputStream()) {
                    e.write(builder.body.getBytes(builder.charset));
                }
            }
            if (builder.after != null) {
                builder.after.accept(conn);
            }
            return handler.apply(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static class Builder {
        private String url;
        private Parameter header;
        private Parameter urlParameter;
        private String body;
        private String method;
        private String charset = "UTF-8";
        private Consumer<HttpURLConnection> before;
        private Consumer<HttpURLConnection> after = conn -> {
            try {
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("the response code is " + conn.getResponseCode());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        public final Builder get(){
            this.method = "GET";
            return this;
        }

        public Builder get(String url){
            return get().url(url);
        }

        public final Builder post(){
            this.method = "POST";
            return this;
        }

        public Builder post(String url){
            return post().url(url);
        }

        public Builder post(String url,String body){
            return post().url(url).body(body);
        }

        public Builder url(String url){
            this.url = url;
            return this;
        }

        public Builder body(String body){
            this.body = body;
            return this;
        }

        public Builder body(Parameter body){
            this.body = body.buildParameter();
            this.contentType("*/*");
            return this;
        }

        public Builder charset(String charset){
            this.charset = charset;
            return this;
        }

        public Builder urlParameter(String key, String value){
            if(urlParameter == null){
                urlParameter = Parameter.create();
            }
            urlParameter.add(key, value);
            return this;
        }

        public Builder urlParameter(Parameter urlParameter){
            this.urlParameter = urlParameter;
            return this;
        }

        public Builder header(String key, String value){
            if(header == null){
                header = Parameter.create();
            }
            header.add(key,value);
            return this;
        }

        public Builder header(Parameter header){
            this.header = header;
            return this;
        }

        public Builder contentType(String contentType) {
            this.header("Content-Type",contentType);
            return this;
        }

        public Builder before(Consumer<HttpURLConnection> before){
            this.before = before;
            return this;
        }

        public Builder after(Consumer<HttpURLConnection> after){
            this.after = after;
            return this;
        }

        public <R> R build(Function<HttpURLConnection,R> handler){
            return HttpKit.execute(this,handler);
        }

        public String asString() {
            return asString(charset);
        }

        public String asString(String charset){
            return build(conn -> {
                try (InputStream inputStream = ToStream.apply(conn)) {
                    StringBuilder sb = new StringBuilder();
                    try (InputStreamReader isr = new InputStreamReader(inputStream, charset); BufferedReader e = new BufferedReader(isr)) {
                        for (String line; (line = e.readLine()) != null; ) {
                            sb.append(line).append("\n");
                        }
                    }
                    return sb.toString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        private String buildUrlParameters() {
            if (urlParameter == null) {
                return url;
            }
            StringBuilder sb = new StringBuilder();
            try {
                for (Iterator<String> i = urlParameter.iterator(); i.hasNext(); ) {
                    String key = i.next();
                    sb.append('&').append(key).append('=').append(URLEncoder.encode(urlParameter.get(key), charset));
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            if (sb.length() == 0) {
                return url;
            } else if (url.indexOf('?') < 0) {
                sb.setCharAt(0,'?');
            }
            return sb.insert(0, url).toString();
        }

    }

    public static class Parameter implements Iterable<String> {
        private Map<String, String> attr;

        private Parameter() {
            attr = new HashMap<>();
        }

        public Parameter add(String key, String value) {
            if (key == null || value == null) {
                return this;
            }
            attr.put(key, value);
            return this;
        }

        public String buildParameter() {
            final int size = attr.size();
            if (size == 0) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            for (String key : attr.keySet()) {
                builder.append('&').append(key).append('=').append(attr.get(key));
            }
            return builder.deleteCharAt(0).toString();
        }

        public String get(String key) {
            return attr.get(key);
        }

        @Override
        public Iterator<String> iterator() {
            return attr.keySet().iterator();
        }

        public static Parameter create() {
            return new Parameter();
        }

        public static Parameter create(String key, String value) {
            return create().add(key, value);
        }
    }

}