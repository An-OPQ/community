package edu.hniu.community.domain;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jerry
 */
public class Notice implements Serializable {

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", createId=" + createId +
                ", noticeContent='" + noticeContent + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
