package com.unipresident.automat.controller;

import com.unipresident.automat.entity.VendorAlipay;
import com.unipresident.automat.entity.VendorReplen;
import com.unipresident.automat.model.Params;
import com.unipresident.automat.model.Request;
import com.unipresident.automat.model.Response;
import com.unipresident.automat.service.VendorService;
import com.unipresident.automat.utils.Signature;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private VendorService vendorService;

    @ModelAttribute("request")
    public Request checkParameters(@RequestBody Request request) {

        int error_code = Signature.checkParameters(request);
        request.setError_code(error_code);

        return request;
    }


    @RequestMapping(value = "/vendor_replen", method = RequestMethod.POST)
    public Response get_vendor_replen(@ModelAttribute("request") Request request) {

        System.out.println(request.getError_code());

        int offset = 0;
        int limit = 20;

        Params params = request.getParams();
        int pageNum = params.getPageNum();
        int pageSize = params.getPageSize();

        offset = (pageNum - 1) * pageSize;
        limit = pageSize;

        String fno = params.getList().get("fno");
        String fstart_time = params.getList().get("fstart_time");
        String fend_time = params.getList().get("fend_time");

        List<VendorReplen> data = vendorService.find_vendor_replen(offset, limit, fno, fstart_time, fend_time);

        Response response = new Response();
        response.setCode(1);
        response.setMessage("OK");
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/vendor_alipay", method = RequestMethod.POST)
    public Response get_vendor_alipay(@ModelAttribute("request") Request request) {

        System.out.println(request.getError_code());

        int offset = 0;
        int limit = 20;

        Params params = request.getParams();
        int pageNum = params.getPageNum();
        int pageSize = params.getPageSize();

        offset = (pageNum - 1) * pageSize;
        limit = pageSize;

        String fno = params.getList().get("fno");
        String fstart_time = params.getList().get("fstart_time");
        String fend_time = params.getList().get("fend_time");
        String fpay_channel_id = params.getList().get("fpay_channel_id");

        String[] fpay_channel_ids = StringUtils.isEmpty(fpay_channel_id)? null : fpay_channel_id.split(",");

        List<VendorAlipay> data = vendorService.find_vendor_alipay(offset, limit, fno, fstart_time, fend_time, fpay_channel_ids);

        Response response = new Response();
        response.setCode(1);
        response.setMessage("OK");
        response.setData(data);
        return response;
    }
}