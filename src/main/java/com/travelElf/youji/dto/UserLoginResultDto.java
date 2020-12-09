package com.travelElf.youji.dto;

public class UserLoginResultDto {
    private String userName;

    public UserLoginResultDto(String userName) {
        super();
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
