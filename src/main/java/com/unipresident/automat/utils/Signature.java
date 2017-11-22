package com.unipresident.automat.utils;

import com.alibaba.fastjson.JSON;
import com.unipresident.automat.model.Params;
import com.unipresident.automat.model.Request;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

public class Signature {

    public static int checkParameters(Request request, String _appkey, String _version, int interval, String secret) {

        String appkey = request.getAppkey();
        String version = request.getVersion();
        String timestamp = request.getTimestamp();
        if(StringUtils.isEmpty(appkey) || !appkey.equals(_appkey)) {
            return -1;
        }

        if(StringUtils.isEmpty(version) || !version.equals(_version)) {
            return -2;
        }

        Date sysDate = new Date();
        long s_timestamp = sysDate.getTime();
        long p_timestamp = Long.parseLong(timestamp);
        if(Math.abs(s_timestamp - p_timestamp) > interval) {
            return -3;
        }

        String sign = request.getSign();
        Params params = request.getParams();

        String _sign = getSignatureStr(appkey, version, String.valueOf(p_timestamp), secret, params);
        if(StringUtils.isEmpty(sign) || !sign.equals(_sign)) {
            return -4;
        }

        return 1;
    }

    public static String getSignatureStr(String appkey, String version, String timestamp, String secret, Params objParams) {

        String params = JSON.toJSONString(objParams);

        String sign = secret + appkey + params + timestamp + version + secret;
        sign = Crypto.md5(sign);
        sign = Crypto.base64(sign);
        return sign;
    }
}
