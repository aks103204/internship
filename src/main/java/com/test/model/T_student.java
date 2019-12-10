package com.test.model;

public class T_student {

  private String sno;

  private String cno;

  private String psd;

  private String name;

  private String phone;

  private String qq;

  public String getSno() {
    return sno;
  }

  public void setSno(String sno) {
    this.sno = sno == null ? null : sno.trim();
  }

  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno == null ? null : cno.trim();
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