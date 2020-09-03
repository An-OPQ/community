package edu.hniu.community.vo;

public class UserRoleVo {

  private long urid;
  private long userid;
  private long roleid;
  private String email;
  private String password;
  private String accountName;
  private String mobile;


  public long getId() {
    return urid;
  }

  public void setId(long id) {
    this.urid = urid;
  }

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

  public long getRoleid() {
    return roleid;
  }

  public void setRoleid(long roleid) {
    this.roleid = roleid;
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

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  @Override
  public String toString() {
    return "UserRoleVo{" +
            "urid=" + urid +
            ", userid=" + userid +
            ", roleid=" + roleid +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", accountName='" + accountName + '\'' +
            ", mobile='" + mobile + '\'' +
            '}';
  }
}
