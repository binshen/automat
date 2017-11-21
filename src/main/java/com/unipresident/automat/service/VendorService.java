package com.unipresident.automat.service;

import com.unipresident.automat.entity.VendorAlipay;
import com.unipresident.automat.entity.VendorReplen;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VendorService {

    public List<VendorReplen> find_vendor_replen(int offset, int limit, String fno, String fstart_time, String fend_time);

    public List<VendorAlipay> find_vendor_alipay(int offset, int limit, String fno, String fstart_time, String fend_time, String[] fpay_channel_ids);
}
