package edu.hniu.community.vo;

/**
 * @author jerry
 */
public class userAndRoleListVo {

    private long roleid;
    private String rolename;
    private long id;
    private String email;
    private String password;
    private String accountName;

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

    @Override
    public String toString() {
        return "userAndRoleListVo{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
