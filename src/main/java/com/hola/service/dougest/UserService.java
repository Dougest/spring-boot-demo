package com.hola.service.dougest;


import com.hola.entity.dougest.User;
import com.hola.util.JsonResult;

import java.util.List;

/**
 * Created by Dougest on 2017/3/10 0010.
 */
public interface UserService {

    JsonResult findUserByUser(User user);

    JsonResult updateUser(User user);

    JsonResult insertUser(User user);

    JsonResult deleteUser(User user);

    JsonResult addMore (List<User> list);



}
