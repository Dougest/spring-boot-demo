//package com.hola.security;
//
//import com.hola.entity.AuthRole;
//import com.hola.entity.AuthUser;
//import com.hola.service.AuthRoleService;
//import com.hola.service.AuthUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Iterator;
//
///**
// * Created by Dougest on 2017/4/9 0009.
// */
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private AuthUserService userService;
//
//    @Autowired
//    private AuthRoleService userRoleService;
//    /**
//     * 根据用户名获取登录用户信息
//     * @param username
//     * @return
//     * @throws UsernameNotFoundException
//     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AuthUser user = userService.findUserByUserName(username);
//
//        if(user == null){
//            throw new UsernameNotFoundException("用户名："+ username + "不存在！");
//        }
//        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
//        Iterator<String> iterator =  userRoleService.findRoles(user.getId()).iterator();
//        while (iterator.hasNext()){
//            collection.add(new SimpleGrantedAuthority(iterator.next()));
//        }
//
//        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),collection);
//    }
//}
