package org.example.practicalunittesting.chp05;

public class User implements IUser{
    private String passwordMd5;
    private final int userId;

    public User(int userId) {
        this.userId = userId;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public String getPassword() {
        return passwordMd5;
    }

    @Override
    public void setPassword(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }
}
