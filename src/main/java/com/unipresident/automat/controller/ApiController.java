package com.unipresident.automat.controller;

import com.unipresident.automat.entity.VendorAlipay;
import com.unipresident.automat.entity.VendorReplen;
import com.unipresident.automat.model.Params;
import com.unipresident.automat.model.Request;
import com.unipresident.automat.model.Response;
import com.unipresident.automat.service.VendorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private VendorService vendorService;

    @RequestMapping(value = "/vendor_replen", method = RequestMethod.POST)
    public Response get_vendor_replen(@RequestBody Request request) {

        Params params = request.getParams();
        String fno = params.getList().get("fno");
        String fstart_time = params.getList().get("fstart_time");
        String fend_time = params.getList().get("fend_time");

        List<VendorReplen> data = vendorService.find_vendor_replen(fno, fstart_time, fend_time);

        Response response = new Response();
        response.setResult(1);
        response.setMessage("OK");
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/vendor_alipay", method = RequestMethod.POST)
    public Response get_vendor_alipay(@RequestBody Request request) {

        Params params = request.getParams();
        String fno = params.getList().get("fno");
        String fstart_time = params.getList().get("fstart_time");
        String fend_time = params.getList().get("fend_time");
        String fpay_channel_id = params.getList().get("fpay_channel_id");

        List<VendorAlipay> data = vendorService.find_vendor_alipay(fno, fstart_time, fend_time, fpay_channel_id);

        Response response = new Response();
        response.setResult(1);
        response.setMessage("OK");
        response.setData(data);
        return response;
    }
}