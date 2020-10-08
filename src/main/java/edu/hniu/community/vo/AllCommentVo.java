package edu.hniu.community.vo;

import edu.hniu.community.domain.CommentMulti;

import java.sql.Timestamp;

/**
 * @author jerry
 */
public class AllCommentVo {
    private long id;
    private long creatorId;
    private long questionId;
    private String commentDescription;
    private java.sql.Timestamp commentDate;
    private long likeCount;
    private long commentCount;
    private String email;
    private String level;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "AllCommentVo{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", questionId=" + questionId +
                ", commentDescription='" + commentDescription + '\'' +
                ", commentDate=" + commentDate +
                ", likeCount=" + likeCount +
                ", commentCount=" + commentCount +
                ", email='" + email + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
