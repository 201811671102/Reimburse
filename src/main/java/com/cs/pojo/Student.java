package com.cs.pojo;

public class Student {
    private Integer sid;

    private String sname;

    private String snumber;

    private String sacademy;

    private String sclass;

    private String sidfront;

    private String sidreverse;

    public Student(Integer sid, String sname, String snumber, String sacademy, String sclass, String sidfront, String sidreverse) {
        this.sid = sid;
        this.sname = sname;
        this.snumber = snumber;
        this.sacademy = sacademy;
        this.sclass = sclass;
        this.sidfront = sidfront;
        this.sidreverse = sidreverse;
    }

    public Student() {
        super();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber == null ? null : snumber.trim();
    }

    public String getSacademy() {
        return sacademy;
    }

    public void setSacademy(String sacademy) {
        this.sacademy = sacademy == null ? null : sacademy.trim();
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass == null ? null : sclass.trim();
    }

    public String getSidfront() {
        return sidfront;
    }

    public void setSidfront(String sidfront) {
        this.sidfront = sidfront == null ? null : sidfront.trim();
    }

    public String getSidreverse() {
        return sidreverse;
    }

    public void setSidreverse(String sidreverse) {
        this.sidreverse = sidreverse == null ? null : sidreverse.trim();
    }
}