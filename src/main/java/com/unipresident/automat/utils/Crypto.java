package com.unipresident.automat.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypto {

    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public static String md5(String str) {
        String new_str = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            new_str = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return new_str;
    }

    /*
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws UnsupportedEncodingException
     */
    public static String base64(String str){
        byte[] tmp = null;
        String new_str = null;
        try {
            tmp = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(tmp != null){
            new_str = new BASE64Encoder().encode(tmp);
        }
        return new_str;
    }

}
