package edu.hniu.community.domain;


import java.sql.Timestamp;

/**
 * @author jerry
 */
public class CommentMulti {

  private long comMultiId;
  private long comId;
  private String comMultiContent;
  private long comMultiUserId;
  private java.sql.Timestamp  comMultiTime;


  public long getComMultiId() {
    return comMultiId;
  }

  public void setComMultiId(long comMultiId) {
    this.comMultiId = comMultiId;
  }


  public long getComId() {
    return comId;
  }

  public void setComId(long comId) {
    this.comId = comId;
  }


  public String getComMultiContent() {
    return comMultiContent;
  }

  public void setComMultiContent(String comMultiContent) {
    this.comMultiContent = comMultiContent;
  }


  public long getComMultiUserId() {
    return comMultiUserId;
  }

  public void setComMultiUserId(long comMultiUserId) {
    this.comMultiUserId = comMultiUserId;
  }

  public Timestamp getComMultiTime() {
    return comMultiTime;
  }

  public void setComMultiTime(Timestamp comMultiTime) {
    this.comMultiTime = comMultiTime;
  }

  @Override
  public String toString() {
    return "CommentMulti{" +
            "comMultiId=" + comMultiId +
            ", comId=" + comId +
            ", comMultiContent='" + comMultiContent + '\'' +
            ", comMultiUserId=" + comMultiUserId +
            ", comMultiTime=" + comMultiTime +
            '}';
  }
}
