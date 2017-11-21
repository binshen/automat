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
    public List<VendorReplen> find_vendor_replen(int offset, int limit, String fno, String fstart_time, String fend_time) {
        return vendorMapper.find_vendor_replen(offset, limit, fno, fstart_time, fend_time);
    }

    @Override
    public List<VendorAlipay> find_vendor_alipay(int offset, int limit, String fno, String fstart_time, String fend_time, String[] fpay_channel_ids) {
        return vendorMapper.find_vendor_alipay(offset, limit, fno, fstart_time, fend_time, fpay_channel_ids);
    }
}
