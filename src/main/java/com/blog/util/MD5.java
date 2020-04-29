package com.blog.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/15 21:04
 */
@Component
public class MD5 {

    public String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 17) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        MD5 md5 = new MD5();
        String s = md5.MD5("666666");
        System.out.println(s);

    }
}
