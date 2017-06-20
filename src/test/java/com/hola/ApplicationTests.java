//package com.hola;
//
///**
// * Created by Dougest on 2017/4/9 0009.
// */
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
///**
// * Created by lxg
// * on 2017/2/20.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(Application.class)
//public class ApplicationTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserRoleRepository userRoleRepository;
//
//    @Test
//    public void test() throws Exception {
//        //User user = userRepository.findByUsername("123");
//        //List<UserRole> userRole = userRoleRepository.findByuid(1);
//
//
//        List<String> list = userRoleRepository.findRoleName(1);
//        System.out.println(list.get(0));
//    }
//}