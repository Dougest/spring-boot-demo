package com.hola.serviceImpl.dougest;

import com.hola.dao.dougest.UserDao;
import com.hola.entity.dougest.User;
import com.hola.service.dougest.UserService;
import com.hola.util.JsonResult;

import com.hola.util.StringUtils;
import com.hola.util.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by Dougest on 2017/3/28 0028.
 */
@Service
public class UserServiceImpl implements UserService{

     @Autowired
    private UserDao userDao;



    public JsonResult findUserByUser(User user) {
        JsonResult json = new JsonResult();
        try{
            if(StringUtils.isEmpty(user.getUserName())) {
                json.setMessage("null loginName");
                json.setFlag(false);
                return json;
            }
            if(StringUtils.isEmpty(user.getUserPwd())) {
                json.setMessage("null password");
                json.setFlag(false);
                return json;
            }

            userDao.findUserByUser(user);
            json.setMessage("success");
            json.setFlag(true);
            return json;
        }catch(Exception e){
            e.printStackTrace();
            json.setMessage("Service Exception");
            json.setFlag(false);
            return json;
        }
    }


    public JsonResult updateUser(User user) {
        JsonResult json = new JsonResult();
        try{
            if(StringUtils.isEmpty(user.getUserName())) {
                json.setMessage("null loginName");
                json.setFlag(false);
                return json;
            }
            if(StringUtils.isEmpty(user.getUserPwd())) {
                json.setMessage("null password");
                json.setFlag(false);
                return json;
            }

            userDao.updateUser(user);
            json.setMessage("success");
            json.setFlag(true);
            return json;
        }catch(Exception e){
            e.printStackTrace();
            json.setMessage("Service Exception");
            json.setFlag(false);
            return json;
        }
    }


    public JsonResult insertUser(User user) {
        JsonResult json = new JsonResult();
        try{
            if(StringUtils.isEmpty(user.getUserName())) {
                json.setMessage("null loginName");
                json.setFlag(false);
                return json;
            }
            if(StringUtils.isEmpty(user.getUserPwd())) {
                json.setMessage("null password");
                json.setFlag(false);
                return json;
            }
            user.setUserId(TimeTools.getLongTypeId());
            userDao.insertUser(user);
            json.setMessage("success");
            json.setFlag(true);
            return json;
        }catch(Exception e){
            e.printStackTrace();
            json.setMessage("Service Exception");
            json.setFlag(false);
            return json;
        }
    }


    public JsonResult deleteUser(User user) {
        JsonResult json = new JsonResult();
        try{
            if(StringUtils.isEmpty(user.getUserName())) {
                json.setMessage("null loginName");
                json.setFlag(false);
                return json;
            }
            if(StringUtils.isEmpty(user.getUserPwd())) {
                json.setMessage("null password");
                json.setFlag(false);
                return json;
            }

            userDao.deleteUser(user);
            json.setMessage("success");
            json.setFlag(true);
            return json;
        }catch(Exception e){
            e.printStackTrace();
            json.setMessage("Service Exception");
            json.setFlag(false);
            return json;
        }
    };


    public JsonResult addMore(List<User> list) {
        JsonResult json = new JsonResult();
        try{
            if(list == null && list.isEmpty()) {
                json.setMessage("null list");
                json.setFlag(false);
                return json;
            }
            for(User user : list) {
                if(StringUtils.isEmpty(user.getUserName())) {
                    json.setMessage("null loginName");
                    json.setFlag(false);
                    return json;
                }
                if(StringUtils.isEmpty(user.getUserPwd())) {
                    json.setMessage("null password");
                    json.setFlag(false);
                    return json;
                }
                user.setUserId(TimeTools.getLongTypeId());
            }

            userDao.addMore(list);
            json.setMessage("success");
            json.setFlag(true);
            return json;
        }catch(Exception e){
            e.printStackTrace();
            json.setMessage("Service Exception");
            json.setFlag(false);
            return json;
        }
    }
}
