package com.test.model;

public class T_admin {
    private String ano;

    private String psd;

    private String name;

    private String phone;

    private String qq;

    public T_admin() {
    }
    public T_admin(String ano,String psd){
        this.ano=ano;
        this.psd=psd;
    }

    public T_admin(String name, String phone, String qq) {
        this.name=name;
        this.phone=phone;
        this.qq=qq;
    }

    public T_admin(String ano, String name, String phone, String qq) {
        this.ano=ano;
        this.name=name;
        this.phone=phone;
        this.qq=qq;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano == null ? null : ano.trim();
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd == null ? null : psd.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }
}