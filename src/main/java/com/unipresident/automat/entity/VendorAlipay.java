package com.unipresident.automat.entity;

public class VendorAlipay {

    private String fcreated_on;
    private String fbill_no;
    private String fno;
    private String favm_goods_chn;
    private String fbarcode;
    private String fsku_name;
    private int fbill_amount;
    private String fpay_channel_id;

    public String getFcreated_on() {
        return fcreated_on;
    }

    public void setFcreated_on(String fcreated_on) {
        this.fcreated_on = fcreated_on;
    }

    public String getFbill_no() {
        return fbill_no;
    }

    public void setFbill_no(String fbill_no) {
        this.fbill_no = fbill_no;
    }

    public String getFno() {
        return fno;
    }

    public void setFno(String fno) {
        this.fno = fno;
    }

    public String getFavm_goods_chn() {
        return favm_goods_chn;
    }

    public void setFavm_goods_chn(String favm_goods_chn) {
        this.favm_goods_chn = favm_goods_chn;
    }

    public String getFbarcode() {
        return fbarcode;
    }

    public void setFbarcode(String fbarcode) {
        this.fbarcode = fbarcode;
    }

    public String getFsku_name() {
        return fsku_name;
    }

    public void setFsku_name(String fsku_name) {
        this.fsku_name = fsku_name;
    }

    public int getFbill_amount() {
        return fbill_amount;
    }

    public void setFbill_amount(int fbill_amount) {
        this.fbill_amount = fbill_amount;
    }

    public String getFpay_channel_id() {
        return fpay_channel_id;
    }

    public void setFpay_channel_id(String fpay_channel_id) {
        this.fpay_channel_id = fpay_channel_id;
    }
}
