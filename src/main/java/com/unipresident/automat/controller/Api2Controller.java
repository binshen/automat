package com.unipresident.automat.controller;

import com.unipresident.automat.entity.VendorAlipay;
import com.unipresident.automat.entity.VendorReplen;
import com.unipresident.automat.model.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api2")
public class Api2Controller {

    @RequestMapping(value = "/vendor_replen", method = RequestMethod.GET)
    public Response get_vendor_replen(
            @RequestParam(value = "pageNum") int pageNum,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "fno", required = false) String fno,
            @RequestParam(value = "fstart_time") String fstart_time,
            @RequestParam(value = "fend_time") String fend_time
    ) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        System.out.println(fno);
        System.out.println(fstart_time);
        System.out.println(fend_time);

        List<VendorReplen> data = new ArrayList<>();
        VendorReplen vendorReplen = new VendorReplen();
        vendorReplen.setFno("93000000");
        vendorReplen.setFavm_goods_chn("13");
        vendorReplen.setFbarcode("6925303781262");
        vendorReplen.setFsku_name("雅哈[意式经典](PET280ml)");
        vendorReplen.setFqty(5);
        vendorReplen.setFadd_time("2017-11-16 11:00:08");
        vendorReplen.setFio("1");
        data.add(vendorReplen);

        Response response = new Response();
        response.setCode(0);
        response.setMessage("OK");
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/vendor_alipay", method = RequestMethod.GET)
    public Response get_vendor_alipay(
            @RequestParam(value = "pageNum") int pageNum,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "fno", required = false) String fno,
            @RequestParam(value = "fstart_time") String fstart_time,
            @RequestParam(value = "fend_time") String fend_time,
            @RequestParam(value = "fpay_channel_id", required = false) String fpay_channel_id

    ) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        System.out.println(fno);
        System.out.println(fstart_time);
        System.out.println(fend_time);
        System.out.println(fpay_channel_id);

        List<VendorAlipay> data = new ArrayList<>();
        VendorAlipay vendorAlipay = new VendorAlipay();
        vendorAlipay.setFcreated_on("2017-11-16 10:00:00");
        vendorAlipay.setFbill_no("9300000201707011111");
        vendorAlipay.setFno("93000000");
        vendorAlipay.setFavm_goods_chn("13");
        vendorAlipay.setFbarcode("6925303781262");
        vendorAlipay.setFsku_name("雅哈[意式经典](PET280ml)");
        vendorAlipay.setFbill_amount(5);
        vendorAlipay.setFpay_channel_id("1");
        data.add(vendorAlipay);

        Response response = new Response();
        response.setCode(0);
        response.setMessage("OK");
        response.setData(data);
        return response;
    }
}
