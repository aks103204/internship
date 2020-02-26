package com.test.model;

import java.util.List;

public class T_teacher {
    private String tno;

    private String tpsd;

    private String tname;

    private String tphone;

    private String tqq;

    private String tprofession;

    private List<T_student> studentList;

    public List<T_student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<T_student> studentList) {
        this.studentList = studentList;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno == null ? null : tno.trim();
    }

    public String getTpsd() {
        return tpsd;
    }

    public void setTpsd(String tpsd) {
        this.tpsd = tpsd == null ? null : tpsd.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone == null ? null : tphone.trim();
    }

    public String getTqq() {
        return tqq;
    }

    public void setTqq(String tqq) {
        this.tqq = tqq == null ? null : tqq.trim();
    }

    public String getTprofession() {
        return tprofession;
    }

    public void setTprofession(String tprofession) {
        this.tprofession = tprofession == null ? null : tprofession.trim();
    }
}