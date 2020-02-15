package com.cs.pojo;

public class Worker {
    private Integer wid;

    private String wname;

    private String wduty;

    private String widfront;

    private String widreverse;

    public Worker(Integer wid, String wname, String wduty, String widfront, String widreverse) {
        this.wid = wid;
        this.wname = wname;
        this.wduty = wduty;
        this.widfront = widfront;
        this.widreverse = widreverse;
    }

    public Worker() {
        super();
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname == null ? null : wname.trim();
    }

    public String getWduty() {
        return wduty;
    }

    public void setWduty(String wduty) {
        this.wduty = wduty == null ? null : wduty.trim();
    }

    public String getWidfront() {
        return widfront;
    }

    public void setWidfront(String widfront) {
        this.widfront = widfront == null ? null : widfront.trim();
    }

    public String getWidreverse() {
        return widreverse;
    }

    public void setWidreverse(String widreverse) {
        this.widreverse = widreverse == null ? null : widreverse.trim();
    }
}