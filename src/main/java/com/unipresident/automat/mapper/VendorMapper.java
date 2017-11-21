package com.unipresident.automat.mapper;

import com.unipresident.automat.entity.VendorAlipay;
import com.unipresident.automat.entity.VendorReplen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VendorMapper {

    public List<VendorReplen> find_vendor_replen(
            @Param("fno") String fno,
            @Param("fstart_time") String fstart_time,
            @Param("fend_time") String fend_time);

    public List<VendorAlipay> find_vendor_alipay(
            @Param("fno") String fno,
            @Param("fstart_time") String fstart_time,
            @Param("fend_time") String fend_time,
            @Param("fpay_channel_id") String fpay_channel_id);
}
