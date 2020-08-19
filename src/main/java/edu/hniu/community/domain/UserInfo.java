package edu.hniu.community.domain;


public class UserInfo {

  private long id;
  private String email;
  private String password;
  private String accountName;
  private String sex;
  private String icon;
  private String sginName;
  private String qq;
  private String weChat;
  private String mobile;
  private String github;
  private String microblog;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getSginName() {
    return sginName;
  }

  public void setSginName(String sginName) {
    this.sginName = sginName;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getWeChat() {
    return weChat;
  }

  public void setWeChat(String weChat) {
    this.weChat = weChat;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getGithub() {
    return github;
  }

  public void setGithub(String github) {
    this.github = github;
  }

  public String getMicroblog() {
    return microblog;
  }

  public void setMicroblog(String microblog) {
    this.microblog = microblog;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", accountName='" + accountName + '\'' +
            ", sex='" + sex + '\'' +
            ", icon='" + icon + '\'' +
            ", sginName='" + sginName + '\'' +
            ", qq='" + qq + '\'' +
            ", weChat='" + weChat + '\'' +
            ", mobile='" + mobile + '\'' +
            ", github='" + github + '\'' +
            ", microblog='" + microblog + '\'' +
            '}';
  }
}
