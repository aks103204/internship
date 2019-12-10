package com.test.model;

public class T_class {

  private String cno;

  private String profession;

  private Integer totalperson;

  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno == null ? null : cno.trim();
  }

  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession == null ? null : profession.trim();
  }

  public Integer getTotalperson() {
    return totalperson;
  }

  public void setTotalperson(Integer totalperson) {
    this.totalperson = totalperson;
  }
}