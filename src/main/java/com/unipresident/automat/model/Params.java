package com.unipresident.automat.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Params implements Serializable {

    private int pageNum;

    private int pageSize;

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
