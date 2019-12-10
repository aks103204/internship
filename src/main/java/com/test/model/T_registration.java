package com.test.model;

public class T_registration {

  private String rno;

  private String province;

  private String city;

  private String company;

  private String linkman;

  private String linkmanphone;

  public String getRno() {
    return rno;
  }

  public void setRno(String rno) {
    this.rno = rno == null ? null : rno.trim();
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province == null ? null : province.trim();
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city == null ? null : city.trim();
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company == null ? null : company.trim();
  }

  public String getLinkman() {
    return linkman;
  }

  public void setLinkman(String linkman) {
    this.linkman = linkman == null ? null : linkman.trim();
  }

  public String getLinkmanphone() {
    return linkmanphone;
  }

  public void setLinkmanphone(String linkmanphone) {
    this.linkmanphone = linkmanphone == null ? null : linkmanphone.trim();
  }
}