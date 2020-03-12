package entities;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private static final long serialVersionUID = 2041275512219239990L;

    private int id;

    private String nickname;

    private String email;

    private String password;

    private Boolean isActive;

    private List<Roles> rolesList;

    public User() {
    }

    public User(String email,boolean isActive ,String nickname, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.rolesList = rolesList;
    }

    public User(int id, String email, boolean isActive, String nickname, String password, List<Roles> rolesList) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.isActive=isActive;
        this.rolesList=rolesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Roles> getRolesList() { return rolesList; }

    public void setRolesList(List<Roles> rolesList) { this.rolesList = rolesList; }

}
