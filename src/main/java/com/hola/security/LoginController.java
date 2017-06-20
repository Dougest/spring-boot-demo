//package com.hola.security;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by Dougest on 2017/4/8 0008.
// *
// * 需要注意的是，Spring Security默认的角色前缀是”ROLE_”,使用hasRole方法时已经默认加上了，
// * 因此我们在数据库里面的用户角色应该是“ROLE_user”，在user前面加上”ROLE_”前缀
// */
//@RestController
//public class LoginController {
//
//
//    //表示访问这个方法需要拥有user角色。如果希望控制到权限层面可以使用@PreAuthorize(“hasPermission()”)
//    @PreAuthorize("hasRole('admin')")
//    @RequestMapping(value = "/login")
//    public String Login(){
//
//        return "backstage/login";
//    }
//
//    @RequestMapping("/index")
//    public String home() {
//        return "backstage/index";
//
//    }
//
//
//    @PreAuthorize("hasRole('user')")
//    @RequestMapping(value = "/admin",method = RequestMethod.POST)
//    public String toAdmin(){
//        return "backstage/helloAdmin";
//    }
//
//    @RequestMapping("/hello")
//    public String hello() {
//
//        return "backstage/hello";
//
//    }
//
//
//    @RequestMapping("/")
//    public String root() {
//        return "backstage/index";
//
//    }
//
//    @RequestMapping("/403")
//    public String error(){
//        return "backstage/403";
//    }
//}
