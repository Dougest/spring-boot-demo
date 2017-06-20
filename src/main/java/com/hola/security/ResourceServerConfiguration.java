//package com.hola.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//
///**
// * Created by Dougest on 2017/4/9 0009.
// *
// * 资源服务器
// */
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
//    private static final String RESOURCE_ID = "my_rest_api";
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.resourceId(RESOURCE_ID).stateless(false);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.
//                anonymous().disable()
//                .requestMatchers().antMatchers("/frontstage1/**","**.css","**.js")
//                .and().authorizeRequests()
//                .antMatchers("/frontstage1/**","**.css","**.js").permitAll()
//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//    }
//}
