package com.unipresident.automat.model;

import java.io.Serializable;
import java.util.Map;

public class Params implements Serializable {

    private int pageNum;

    private int pageSize;

    private Map list;

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

    public Map getList() {
        return list;
    }

    public void setList(Map list) {
        this.list = list;
    }
}
