package edu.hniu.community.domain;


import java.io.Serializable;

/**
 * @author jerry
 */
public class Advert implements Serializable {

  private long id;
  private long createId;
  private String pictureAddress;
  private String advertName;
  private java.sql.Timestamp createTime;
  private String advertURL;

  public String getAdvertURL() {
    return advertURL;
  }

  public void setAdvertURL(String advertURL) {
    this.advertURL = advertURL;
  }

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


  public String getPictureAddress() {
    return pictureAddress;
  }

  public void setPictureAddress(String pictureAddress) {
    this.pictureAddress = pictureAddress;
  }


  public String getAdvertName() {
    return advertName;
  }

  public void setAdvertName(String advertName) {
    this.advertName = advertName;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "Advert{" +
            "id=" + id +
            ", createId=" + createId +
            ", pictureAddress='" + pictureAddress + '\'' +
            ", advertName='" + advertName + '\'' +
            ", createTime=" + createTime +
            ", advertURL='" + advertURL + '\'' +
            '}';
  }
}
