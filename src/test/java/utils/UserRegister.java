package utils;

import pojo.CreatePojo;

public class UserRegister {

    public CreatePojo fillUser(){

        CreatePojo user = new CreatePojo();

        user.setName("morpheus");
        user.setJob("leader");

        return user;
    }
    public CreatePojo requiredFields(){

        CreatePojo user = new CreatePojo();

        user.setName("");
        user.setJob("leader");

        return user;
    }

    public CreatePojo contract(){

        CreatePojo user = new CreatePojo();

        user.setName("morpheus");

        return user;
    }
}