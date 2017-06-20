package com.hola.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class TimeTools {

    public static Long getLongTypeId() {
        String a = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+(int)(Math.random()*100);
        /*基本类型的long 不是包装类*/
        return Long.parseLong(a);
    }

    public static String  getStringTypeId() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+(int)(Math.random()*100);
    }

    public static void main(String[] args) {
        String a = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+(int)(Math.random()*100);
        System.out.println(a);
    }
}
