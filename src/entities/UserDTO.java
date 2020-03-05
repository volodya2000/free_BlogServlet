package entities;

public class UserDTO {

    private int id;

    private String email;

    private boolean isActive;

    private String nickname;

    private String password;

    public UserDTO(String email, boolean isActive, String nickname, String password) {
        this.email = email;
        this.isActive = isActive;
        this.nickname = nickname;
        this.password = password;
    }

    public UserDTO(int id, String email, boolean isActive, String nickname, String password) {
        this.id = id;
        this.email = email;
        this.isActive = isActive;
        this.nickname = nickname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id){
        this.id=Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
