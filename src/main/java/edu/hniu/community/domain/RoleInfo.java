package edu.hniu.community.domain;


/**
 * @author jerry
 */
public class RoleInfo {

  private long roleid;
  private String rolename;

  private UserInfo userInfo;

  public UserInfo getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  public long getRoleid() {
    return roleid;
  }

  public void setRoleid(long roleid) {
    this.roleid = roleid;
  }


  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }


  @Override
  public String toString() {
    return "Roleinfo{" +
            "roleid=" + roleid +
            ", rolename='" + rolename + '\'' +
            ", userInfo=" + userInfo +
            '}';
  }
}
