package com.cs.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Reimburse {
    private Integer rid;

    private String rhospital;

    private String rhospitalinvoice;

    private String rmoney;

    private String rmoneyinvoice;

    private Integer rprove;

    private String rproveinvoice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rtime;

    public Reimburse(Integer rid, String rhospital, String rhospitalinvoice, String rmoney, String rmoneyinvoice, Integer rprove, String rproveinvoice, Date rtime) {
        this.rid = rid;
        this.rhospital = rhospital;
        this.rhospitalinvoice = rhospitalinvoice;
        this.rmoney = rmoney;
        this.rmoneyinvoice = rmoneyinvoice;
        this.rprove = rprove;
        this.rproveinvoice = rproveinvoice;
        this.rtime = rtime;
    }

    public Reimburse() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRhospital() {
        return rhospital;
    }

    public void setRhospital(String rhospital) {
        this.rhospital = rhospital == null ? null : rhospital.trim();
    }

    public String getRhospitalinvoice() {
        return rhospitalinvoice;
    }

    public void setRhospitalinvoice(String rhospitalinvoice) {
        this.rhospitalinvoice = rhospitalinvoice == null ? null : rhospitalinvoice.trim();
    }

    public String getRmoney() {
        return rmoney;
    }

    public void setRmoney(String rmoney) {
        this.rmoney = rmoney == null ? null : rmoney.trim();
    }

    public String getRmoneyinvoice() {
        return rmoneyinvoice;
    }

    public void setRmoneyinvoice(String rmoneyinvoice) {
        this.rmoneyinvoice = rmoneyinvoice == null ? null : rmoneyinvoice.trim();
    }

    public Integer getRprove() {
        return rprove;
    }

    public void setRprove(Integer rprove) {
        this.rprove = rprove;
    }

    public String getRproveinvoice() {
        return rproveinvoice;
    }

    public void setRproveinvoice(String rproveinvoice) {
        this.rproveinvoice = rproveinvoice == null ? null : rproveinvoice.trim();
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }
}