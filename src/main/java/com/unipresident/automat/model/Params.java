package com.unipresident.automat.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Params implements Serializable {

    @JSONField(ordinal=1)
    private int pageNum;

    @JSONField(ordinal=2)
    private int pageSize;

    @JSONField(ordinal=3)
    private LinkedHashMap<String, String> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public LinkedHashMap<String, String> getList() {
        return list;
    }

    public void setList(LinkedHashMap<String, String> list) {
        this.list = list;
    }
}
