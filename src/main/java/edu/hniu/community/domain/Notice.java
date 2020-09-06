package com.sample;


public class Notice {

  private long id;
  private long createId;
  private String noticeContent;
  private java.sql.Timestamp createTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCreateId() {
    return createId;
  }

  public void setCreateId(long createId) {
    this.createId = createId;
  }


  public String getNoticeContent() {
    return noticeContent;
  }

  public void setNoticeContent(String noticeContent) {
    this.noticeContent = noticeContent;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

}
