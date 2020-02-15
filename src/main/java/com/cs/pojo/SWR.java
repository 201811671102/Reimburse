package com.cs.pojo;

public class SWR {
    private Integer sid;

    private Integer wid;

    private Integer rid;

    private Double reimbursemoney;

    public SWR(Integer sid, Integer wid, Integer rid, Double reimbursemoney) {
        this.sid = sid;
        this.wid = wid;
        this.rid = rid;
        this.reimbursemoney = reimbursemoney;
    }

    public SWR() {
        super();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Double getReimbursemoney() {
        return reimbursemoney;
    }

    public void setReimbursemoney(Double reimbursemoney) {
        this.reimbursemoney = reimbursemoney;
    }
}