package edu.hniu.community.vo;

/**
 * @author jerry
 */
public class searchUserVo {

    private String accountName;
    private String email;
    private String roleid;
    private int pageNo;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "searchUserVo{" +
                "accountName='" + accountName + '\'' +
                ", email='" + email + '\'' +
                ", roleid='" + roleid + '\'' +
                ", pageNo=" + pageNo +
                '}';
    }
}
