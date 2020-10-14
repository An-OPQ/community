package edu.hniu.community.domain;


import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {

  private long id;
  private long creatorId;
  private long questionId;
  private String commentDescription;
  private java.sql.Timestamp commentDate;
  private String likeCount;
  private String commentCount;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(long creatorId) {
    this.creatorId = creatorId;
  }


  public long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(long questionId) {
    this.questionId = questionId;
  }


  public String getCommentDescription() {
    return commentDescription;
  }

  public void setCommentDescription(String commentDescription) {
    this.commentDescription = commentDescription;
  }


  public Timestamp getCommentDate() {
    return commentDate;
  }

  public void setCommentDate(Timestamp commentDate) {
    this.commentDate = commentDate;
  }

  public String getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(String likeCount) {
    this.likeCount = likeCount;
  }


  public String getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(String commentCount) {
    this.commentCount = commentCount;
  }

  @Override
  public String toString() {
    return "Comment{" +
            "id=" + id +
            ", creatorId=" + creatorId +
            ", questionId=" + questionId +
            ", commentDescription='" + commentDescription + '\'' +
            ", commentDate='" + commentDate + '\'' +
            ", likeCount='" + likeCount + '\'' +
            ", commentCount='" + commentCount + '\'' +
            '}';
  }
}
