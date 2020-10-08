package edu.hniu.community.domain;


import edu.hniu.community.vo.AllCommentVo;

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
  private long likeCount;
  private long commentCount;


  private UserInfo userInfo;

  public UserInfo getUserInfo() {
    return userInfo;
  }

  public long getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(long likeCount) {
    this.likeCount = likeCount;
  }

  public long getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(long commentCount) {
    this.commentCount = commentCount;
  }

  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

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
            ", likeCount=" + likeCount +
            ", commentCount=" + commentCount +
            ", userInfo=" + userInfo +
            '}';
  }
}
