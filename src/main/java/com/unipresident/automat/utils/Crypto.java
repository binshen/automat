package com.unipresident.automat.utils;

import org.apache.commons.codec.binary.Base64;

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
        try {
            MessageDigest digist = MessageDigest.getInstance("MD5");
            byte[] rs = digist.digest(str.getBytes("UTF-8"));
            StringBuffer digestHexStr = new StringBuffer();
            for (int i = 0; i < 16; i++) {
                digestHexStr.append(byteHEX(rs[i]));
            }
            return digestHexStr.toString();
        } catch (Exception e) {
        }
        return null;
    }

    public static String byteHEX(byte ib) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        return new String(ob);
    }

    /*
     * @param str  待加密的字符串
     * @return  加密后的字符串
     */
    public static String base64(String str){
        try {
            return Base64.encodeBase64String(str.getBytes("UTF-8"));
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(md5("123qwe"));
        System.out.println(base64("123qwe"));
    }
}
