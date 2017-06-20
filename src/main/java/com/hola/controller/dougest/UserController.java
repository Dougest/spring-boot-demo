package com.hola.controller.dougest;

import com.hola.entity.dougest.User;
import com.hola.service.dougest.UserService;
import com.hola.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dougest on 2017/3/28 0028.
 */
@RestController
@RequestMapping(value = "/", method = RequestMethod.GET)
public class UserController {
    @Autowired
    private UserService userService;

    /*@RequestMapping("/login")
    public JsonResutl login(@RequestBody User user) {
        JsonResutl json = userService.findUserByUser(user);
        return json;
    }*/
    public static void main(String[] args) {
		System.out.println("");
	}


}
