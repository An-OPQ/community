package edu.hniu.community.domain;


public class Question {

    private long id;
    private String title;
    private String description;
    private long creatorid;
    private String createDate;
    private long commentCount;
    private long viewCount;
    private long likeCount;
    private long typeid;

    private QuestionType questionType;

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(long creatorid) {
        this.creatorid = creatorid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getTypeid() {
        return typeid;
    }

    public void setTypeid(long typeid) {
        this.typeid = typeid;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creatorid=" + creatorid +
                ", createDate='" + createDate + '\'' +
                ", commentCount=" + commentCount +
                ", viewCount=" + viewCount +
                ", likeCount=" + likeCount +
                ", typeid=" + typeid +
                ", questionType=" + questionType +
                '}';
    }
}
