package com.test.model;

public class T_tcKey {

  private String cno;

  private String tno;

  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno == null ? null : cno.trim();
  }

  public String getTno() {
    return tno;
  }

  public void setTno(String tno) {
    this.tno = tno == null ? null : tno.trim();
  }
}