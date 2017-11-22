package com.unipresident.automat.utils;

import com.alibaba.fastjson.JSON;
import com.unipresident.automat.model.Params;
import com.unipresident.automat.model.Request;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Signature {

    private static String _appkey = "1234567890";
    private static String _secret = "qwertyuiop";
    private static String _version = "V1";


    public static int checkParameters(Request request) {

        String appkey = request.getAppkey();
        String version = request.getVersion();
        String timestamp = request.getTimestamp();
        if(StringUtils.isEmpty(appkey) || _appkey.equals(appkey)) {
            return -1;
        }

        if(StringUtils.isEmpty(version) || _version.equals(version)) {
            return -2;
        }

        Date systemDate = new Date();
        long s_timestamp = systemDate.getTime();
        long p_timestamp = Integer.parseInt(timestamp);
        if(Math.abs(s_timestamp - p_timestamp) > 5000) {
            return -3;
        }

        String sign = request.getSign();
        Params params = request.getParams();

        String _sign = getSignatureStr(appkey, version, params);
        if(StringUtils.isEmpty(sign) || sign.equals(_sign)) {
            return -4;
        }

        return 1;
    }

    private static String getSignatureStr(String appkey, String version, Params objParams) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = format.format(new Date());

        String params = JSON.toJSONString(objParams);

        String sign = _secret + appkey + params + timestamp + version + _secret;
        sign = Crypto.md5(sign);
        sign = Crypto.base64(sign);
        return sign;
    }

    public static void main(String[] args) {

        LinkedHashMap list = new LinkedHashMap();
        list.put("fno", "93000000");
        list.put("fstart_time", "2017-11-15 00:00:00");
        list.put("fend_time", "2017-11-16 00:00:00");

        Params params = new Params();
        params.setPageNum(1);
        params.setPageSize(20);
        params.setList(list);

        String strParams = JSON.toJSONString(params);
        System.out.println(strParams);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
