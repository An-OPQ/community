package edu.hniu.community.vo;

import java.sql.Timestamp;

/**
 * @author jerry
 */
public class NoticeVo {
    private long id;
    private long create_id;
    private String notice_content;
    private Timestamp create_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreate_id() {
        return create_id;
    }

    public void setCreate_id(long create_id) {
        this.create_id = create_id;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "NoticeVo{" +
                "id=" + id +
                ", create_id=" + create_id +
                ", notice_content='" + notice_content + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
