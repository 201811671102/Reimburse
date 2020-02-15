package com.cs.pojo;

public class User {
    private Integer uid;

    private String account;

    private String password;

    private Integer type;

    public User(Integer uid, String account, String password, Integer type) {
        this.uid = uid;
        this.account = account;
        this.password = password;
        this.type = type;
    }

    public User() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}