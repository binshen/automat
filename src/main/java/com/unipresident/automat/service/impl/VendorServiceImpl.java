package com.unipresident.automat.service.impl;

import com.unipresident.automat.entity.VendorAlipay;
import com.unipresident.automat.entity.VendorReplen;
import com.unipresident.automat.mapper.VendorMapper;
import com.unipresident.automat.service.VendorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Resource
    @Qualifier("vendorMapper")
    private VendorMapper vendorMapper;

    @Override
    public List<VendorReplen> find_vendor_replen(String fno, String fstart_time, String fend_time) {
        return vendorMapper.find_vendor_replen(fno, fstart_time, fend_time);
    }

    @Override
    public List<VendorAlipay> find_vendor_alipay(String fno, String fstart_time, String fend_time, String fpay_channel_id) {
        return vendorMapper.find_vendor_alipay(fno, fstart_time, fend_time, fpay_channel_id);
    }
}
