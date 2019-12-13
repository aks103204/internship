package com.test.model;

import java.util.List;

public class T_class {
    private String cno;

    private String cprofession;

    private Integer totalperson;

    private List<T_student> studentList;

    public List<T_student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<T_student> studentList) {
        this.studentList = studentList;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno == null ? null : cno.trim();
    }

    public String getCprofession() {
        return cprofession;
    }

    public void setCprofession(String cprofession) {
        this.cprofession = cprofession == null ? null : cprofession.trim();
    }

    public Integer getTotalperson() {
        return totalperson;
    }

    public void setTotalperson(Integer totalperson) {
        this.totalperson = totalperson;
    }
}