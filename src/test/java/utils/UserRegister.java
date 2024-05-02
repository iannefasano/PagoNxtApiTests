package utils;

import pojo.CreatePojo;

public class UserRegister {

    public CreatePojo fillUser(){

        CreatePojo user = new CreatePojo();

        user.setName("morpheus");
        user.setJob("leader");

        return user;
    }
}