package com.test.model;

import java.util.List;

public class T_student {
    private String sno;

    private String cno;

    private String spsd;

    private String sname;

    private String sphone;

    private String qq;

    private List<T_teacher> teacherList;

    public List<T_teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<T_teacher> teacherList) {
        this.teacherList = teacherList;
    }

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

    public String getSpsd() {
        return spsd;
    }

    public void setSpsd(String spsd) {
        this.spsd = spsd == null ? null : spsd.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone == null ? null : sphone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }
}