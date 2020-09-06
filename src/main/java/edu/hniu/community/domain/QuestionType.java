package com.sample;


public class QuestionType {

  private long typeId;
  private String typeName;
  private java.sql.Timestamp typeCreateTime;


  public long getTypeId() {
    return typeId;
  }

  public void setTypeId(long typeId) {
    this.typeId = typeId;
  }


  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }


  public java.sql.Timestamp getTypeCreateTime() {
    return typeCreateTime;
  }

  public void setTypeCreateTime(java.sql.Timestamp typeCreateTime) {
    this.typeCreateTime = typeCreateTime;
  }

}
