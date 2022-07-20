package edu.hniu.community.vo;

import java.sql.Timestamp;

/**
 * @author jerry
 */
public class QuestionTypeVo {

    private long type_id;
    private String type_name;
    private Timestamp type_createTime;

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Timestamp getType_createTime() {
        return type_createTime;
    }

    public void setType_createTime(Timestamp type_createTime) {
        this.type_createTime = type_createTime;
    }

    @Override
    public String toString() {
        return "QuestionTypeVo{" +
                "type_id=" + type_id +
                ", type_name='" + type_name + '\'' +
                ", type_createTime=" + type_createTime +
                '}';
    }
}
