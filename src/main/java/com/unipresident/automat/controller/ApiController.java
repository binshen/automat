package com.unipresident.automat.controller;

import com.unipresident.automat.model.Request;
import com.unipresident.automat.model.Response;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/goods_aisle_info", method = RequestMethod.POST)
    public Response get_goods_aisle_info(@RequestBody Request request) {

        System.out.println(request);

        Response response = new Response();
        response.setResult(1);
        response.setMessage("OK");
        Map[] data = new Map[1];
        Map map = new HashMap();
        map.put("fno", "93000000");
        map.put("favm_goods_chn", "13");
        map.put("fbarcode", "6925303781262");
        map.put("fsku_name", "雅哈[意式经典](PET280ml)");
        map.put("fqty", 5);
        map.put("fadd_time", "2017-11-16 11:00:08");
        map.put("fio", "1");
        data[0] = map;
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/transaction_detail", method = RequestMethod.POST)
    public Response get_transaction_detail(@RequestBody Request request) {

        System.out.println(request);

        Response response = new Response();
        response.setResult(1);
        response.setMessage("OK");
        Map[] data = new Map[1];
        Map map = new HashMap();
        map.put("fcreated_on", "2017-11-16 10:00:00");
        map.put("fbill_no", "9300000201707011111");
        map.put("fno", "93000000");
        map.put("favm_goods_chn", "13");
        map.put("fbarcode", "6925303781262");
        map.put("fsku_name", "雅哈[意式经典](PET280ml)");
        map.put("fbill_amount", 5);
        map.put("fpay_channel_id", "1");
        data[0] = map;
        response.setData(data);
        return response;
    }
}