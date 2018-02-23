package org.talknow.model;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private static int lastUserId;

    public User() {
        this.userId = ++lastUserId;
    }

    public User(String userName, String password, String email) {
        this.userId = ++lastUserId;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
    
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email + '}';
    }
    
}
