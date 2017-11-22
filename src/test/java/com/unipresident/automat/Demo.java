package com.unipresident.automat;

import com.alibaba.fastjson.JSON;
import com.unipresident.automat.model.Params;
import com.unipresident.automat.utils.Crypto;
import com.unipresident.automat.utils.Signature;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashMap;

public class Demo {

    private static String strURL = "http://localhost:8080/api/vendor_alipay";

    public static void main(String[] args) {
        try {
            //创建连接
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("contentType", "application/json");
            connection.connect();

            //POST请求
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());

            String appkey = "1234567890";
            String secret = "qwertyuiop";
            long timestamp = new Date().getTime();
            String version = "V1";

            JSONObject postVars = new JSONObject();
            postVars.put("appkey", appkey);
            postVars.put("timestamp", timestamp);
            postVars.put("version", version);

            LinkedHashMap list = new LinkedHashMap();
            list.put("fno", "95000000");
            list.put("fstart_time", "2017-11-17 00:00:00");
            list.put("fend_time", "2017-11-27 00:00:00");
            list.put("fpay_channel_id", "1,2,3");
            Params params = new Params();
            params.setPageNum(1);
            params.setPageSize(20);
            params.setList(list);


            JSONObject obj1 = new JSONObject();
            obj1.put("pageNum", "1");
            obj1.put("pageSize", "20");
            JSONObject obj2 = new JSONObject();
            obj2.put("fno", "95000000");
            obj2.put("fstart_time", "2017-11-17 00:00:00");
            obj2.put("fend_time", "2017-11-27 00:00:00");
            obj2.put("fpay_channel_id", "1,2,3");
            obj1.put("list", obj2);
            postVars.put("params", obj1);

            System.out.println(JSON.toJSONString(params));
            System.out.println(JSON.toJSONString(obj1));

            String sign = Signature.getSignatureStr(appkey, version, String.valueOf(timestamp), secret, params);
            System.out.println(sign);
            postVars.put("sign", sign);

            System.out.println(postVars.toString());

            out.write(postVars.toString().getBytes());
            out.flush();
            out.close();

            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
