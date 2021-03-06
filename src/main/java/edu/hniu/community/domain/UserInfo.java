package edu.hniu.community.domain;


import java.io.Serializable;

public class UserInfo implements Serializable {

  private long id;
  private String email;
  private String password;
  private String accountName;
  private long roleid;
  private String token;
  private String sex;
  private String icon;
  private String sginName;
  private String qq;
  private String weChat;
  private String mobile;
  private String github;
  private String microblog;
  private Comment comment;

  private RoleInfo roleInfo;

  private  Question question;

  public RoleInfo getRoleInfo() {
    return roleInfo;
  }

  public void setRoleInfo(RoleInfo roleInfo) {
    this.roleInfo = roleInfo;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

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


  public long getRoleid() {
    return roleid;
  }

  public void setRoleid(long roleid) {
    this.roleid = roleid;
  }


  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
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
            ", roleid=" + roleid +
            ", token='" + token + '\'' +
            ", sex='" + sex + '\'' +
            ", icon='" + icon + '\'' +
            ", sginName='" + sginName + '\'' +
            ", qq='" + qq + '\'' +
            ", weChat='" + weChat + '\'' +
            ", mobile='" + mobile + '\'' +
            ", github='" + github + '\'' +
            ", microblog='" + microblog + '\'' +
            ", comment=" + comment +
            ", question=" + question +
            '}';
  }
}
