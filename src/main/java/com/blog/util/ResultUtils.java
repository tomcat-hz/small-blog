package com.blog.util;

import com.blog.bean.User;

/**
 * @description 传入对应的参数返回布尔值
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/27 15:38
 */
public class ResultUtils {

    //用于测试工具类的方法
    public static void main(String[] args) {
    }

    public static Boolean result(Object o) {
        if (o==null) {
            //为null表示查询不到
            return false;
        }
        if (o instanceof Integer) {
            Integer i = (Integer) o;
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }
        if (o instanceof User) {
            User user = (User) o;
            //用户不存在返回false
            if (user == null) {
                return false;
            } else {
                return true;
            }
        }
        return null;
    }
}
