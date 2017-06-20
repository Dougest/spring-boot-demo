package com.hola.controller.dougest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dougest on 2017/3/30 0030.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello1")
    public String comeInindex() {
        return "Hello World";
    }
}
