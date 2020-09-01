package edu.hniu.community.domain;


/**
 * @author jerry
 */
public class Roleinfo {

  private long roleid;
  private String rolename;


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
            '}';
  }
}
