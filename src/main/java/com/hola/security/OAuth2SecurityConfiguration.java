//package com.hola.security;
//
//import com.hola.entity.AuthUser;
//import com.hola.service.AuthRoleService;
//import com.hola.service.AuthUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.approval.ApprovalStore;
//import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
//import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
//import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Iterator;
//
///**
// * Created by Dougest on 2017/4/8 0008.
// * security配置
// */
//public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private ClientDetailsService clientDetailsService;
//
//    @Autowired
//    private RedisConnectionFactory redisConnection;
//
//    @Bean
//    public MyUserDetailsService myUserDetailsService(){
//        return new MyUserDetailsService();
//    }
//    @Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(myUserDetailsService())
//                .passwordEncoder(new Md5PasswordEncoder());
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .anonymous().disable()
//                .authorizeRequests()
//                .antMatchers("/oauth/token").permitAll();
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new RedisTokenStore(redisConnection);
//    }
//
//    @Bean
//    @Autowired
//    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore){
//        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
//        handler.setTokenStore(tokenStore);
//        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
//        handler.setClientDetailsService(clientDetailsService);
//        return handler;
//    }
//
//    @Bean
//    @Autowired
//    public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
//        TokenApprovalStore store = new TokenApprovalStore();
//        store.setTokenStore(tokenStore);
//        return store;
//    }
//}