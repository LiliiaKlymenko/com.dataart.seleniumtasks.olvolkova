package utils;

import entities.User;

public class TestData {
    public static User getValidUser() {
        return new User().withLogin("admin").withPassword("admin");
    }

    public static User getInvalidUser() {
        return new User().withLogin("invalidlogin").withPassword("invalidpassword");
    }



}
