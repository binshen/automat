package com.unipresident.automat.utils;

import com.unipresident.automat.model.Params;
import com.unipresident.automat.model.Request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Signature {

    private static String appkey = "123456";
    private static String secret = "qwerty";
    private static String version = "V1";


    public static int checkParameters(Request request) {

        String appkey = request.getAppkey();
        String sign = request.getSign();
        String timestamp = request.getTimestamp();
        String version = request.getVersion();
        Params params = request.getParams();

        

        return 0;
    }

    private static String getSignatureStr(Map map) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = format.format(new Date());

        String params = "";
        if(map != null && !map.isEmpty()) {
            for (Object key : map.keySet()) {
                params += String.valueOf(key) + map.get(key);
            }
        }

        String sign = secret + appkey + params + timestamp + version + secret;
        sign = Crypto.md5(sign);
        sign = Crypto.base64(sign);
        return sign;
    }

    public static void main(String[] args) {

        Map params = new LinkedHashMap();
        params.put("fno", "93000000");
        params.put("fstart_time", "2017-11-15 00:00:00");
        params.put("fend_time", "2017-11-16 00:00:00");

        String sign = getSignatureStr(params);
        System.out.println(sign);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
