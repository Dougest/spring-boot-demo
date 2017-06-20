package com.hola.controller.dougest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hola.dao.dougest.MessageDao;
import com.hola.entity.dougest.Message;
import com.hola.util.JsonResult;
import com.hola.util.StringUtils;

@RestController
@RequestMapping(value="/message")
public class MessageController {
	@Autowired
	private MessageDao messageDao;
	@SuppressWarnings("rawtypes")
	private JsonResult json = new JsonResult();
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/questionnaire")
	public JsonResult questionnaire(String message,HttpServletRequest req){
//		System.out.println("getIpAddr:"+getIpAddr(req));
//        System.out.println("getRemoteAddr:"+getRemoteAddr(req));
//        System.out.println("getClientIpAddr:"+getClientIpAddr(req));
//        System.out.println("getClientIpAddress:"+getClientIpAddress(req));
//        System.out.println("getRealIp:"+getRealIp(req));
//		Enumeration<String> getHeaderNames = req.getHeaderNames();
//		while (getHeaderNames.hasMoreElements()) {
//		    Object o= getHeaderNames.nextElement();
//		    System.out.println(o);
//		}
//		System.out.println("host"+req.getHeader("host"));
//		System.out.println("connection"+req.getHeader("connection"));
//		System.out.println("content-length"+req.getHeader("content-length"));
//		System.out.println("origin"+req.getHeader("origin"));
//		System.out.println("user-agent"+req.getHeader("user-agent"));
//		System.out.println("content-type"+req.getHeader("content-type"));
//		System.out.println("accept"+req.getHeader("accept"));
//		System.out.println("x-requested-with"+req.getHeader("x-requested-with"));
//		System.out.println("referer"+req.getHeader("referer"));
//		System.out.println("accept-encoding"+req.getHeader("accept-encoding"));
//		System.out.println("accept-language"+req.getHeader("accept-language"));
		if(message == null) {
			json.setFlag(false);
			return json;
		}
		try{
			System.out.println("front=>>>>>>>>>>>>>>>>>>>"+message);
			//message = URLDecoder.decode(message, "utf-8");
			//System.out.println("back=>>>>>>>>>>>>>>>>>>>"+message);
			Message m = new Message();
			m.setIp(getRealIp(req));
			m.setContent(message);
			m.setAddress(req.getRemoteAddr());
			m.setHost(req.getRemoteHost());
			m.setCreatTime(new Date());
			m.setLocale(req.getLocale().toString());
			m.setScheme(req.getScheme());
			m.setUserAgent(req.getHeader("User-Agent"));
			messageDao.save(m);
			json.setFlag(true);
			json.setStateCode(200);
		return json;
		}catch(Exception e){
			json.setFlag(false);
			json.setMessage("服务器异常");
			e.printStackTrace();
			return json;
		}
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "%E6%9C%89%E6%97%B6%E5%80%99%20%E6%88%91%E7%BB%8F%E5%B8%B8%E5%86%8D%E6%83%B3%E4%B8%80%E4%B8%AA%E9%97%AE%E9%A2%98%20:%E2%80%9C%E6%98%8E%E6%98%8E%E8%85%B0%E7%97%9B%E8%85%BF%E8%BD%AF%20%E4%B8%BA%E4%BB%80%E4%B9%88%E8%BF%98%E8%A6%81%E2%80%A6%E5%B0%B1%E4%B8%8D%E8%83%BD%E5%85%8B%E5%88%B6%E4%B8%80%E4%B8%8B%20%20%20";
		String b ="%E5%AD%99%E6%A0%93%E6%A0%93%E4%B8%8E%E4%BD%A0%E5%90%8C%E5%9C%A8%E3%80%82";
		a = URLDecoder.decode(a, "utf-8");
		b = URLDecoder.decode(b, "utf-8");
		System.out.println("front=>>>>>>>>>>>>>>>>>>>"+a);
		System.out.println("front=>>>>>>>>>>>>>>>>>>>"+b);
	}
	
	public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
	/**
     * 获取客户端ip地址(可以穿透代理)
     * 
     * @param request
     * @return
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    private static final String[] HEADERS_TO_TRY = { 
        "X-Forwarded-For",
        "Proxy-Client-IP",
        "WL-Proxy-Client-IP",
        "HTTP_X_FORWARDED_FOR",
        "HTTP_X_FORWARDED",
        "HTTP_X_CLUSTER_CLIENT_IP",
        "HTTP_CLIENT_IP",
        "HTTP_FORWARDED_FOR",
        "HTTP_FORWARDED",
        "HTTP_VIA",
        "REMOTE_ADDR",
        "X-Real-IP"};

    /***
     * 获取客户端ip地址(可以穿透代理)
     * @param request
     * @return
     */
    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }
    /***
     * 获取客户端ip地址(可以穿透代理)
     * @param request
     * @return
     */
    public static String getClientIpAddr(HttpServletRequest request) {  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_FORWARDED");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_VIA");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("REMOTE_ADDR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (null != ip && !"".equals(ip.trim())
                && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (null != ip && !"".equals(ip.trim())
                && !"unknown".equalsIgnoreCase(ip)) {
            // get first ip from proxy ip
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }
}
