package edu.hniu.community.vo;

public class FileUploadVo {
    private String email;
    private String icon;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "vo{" +
                "email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
