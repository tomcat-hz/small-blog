package com.blog.util;

/**
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/27 16:06
 */
public class RandomNumber {

    public static void main(String[] args) {
        String code = getCode(6);
        System.out.println(code);
    }

    public static String getCode(int length) {
        String random = "";
        for (int i = 0; i < length; i++) {
            int j = (int) (Math.random() * 10);
            random += j;
        }
        return random;
    }
}
