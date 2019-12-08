package com.test.model;

public class T_file {
    private Integer fno;

    private String filename;

    private String filetype;

    private String time;

    private Integer taskNo;

    private String owePerno;

    public Integer getFno() {
        return fno;
    }

    public void setFno(Integer fno) {
        this.fno = fno;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(Integer taskNo) {
        this.taskNo = taskNo;
    }

    public String getOwePerno() {
        return owePerno;
    }

    public void setOwePerno(String owePerno) {
        this.owePerno = owePerno == null ? null : owePerno.trim();
    }
}