package com.test.model;

import java.util.Date;

public class Task {

  private Integer taskNo;

  private String taskName;

  private String tno;

  private String taskContent;

  private Boolean submit;

  private Date startTime;

  private Date endTime;

  private Date createTime;

  public Integer getTaskNo() {
    return taskNo;
  }

  public void setTaskNo(Integer taskNo) {
    this.taskNo = taskNo;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName == null ? null : taskName.trim();
  }

  public String getTno() {
    return tno;
  }

  public void setTno(String tno) {
    this.tno = tno == null ? null : tno.trim();
  }

  public String getTaskContent() {
    return taskContent;
  }

  public void setTaskContent(String taskContent) {
    this.taskContent = taskContent == null ? null : taskContent.trim();
  }

  public Boolean getSubmit() {
    return submit;
  }

  public void setSubmit(Boolean submit) {
    this.submit = submit;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}