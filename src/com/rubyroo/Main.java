package com.rubyroo;

import com.rubyroo.bean.User;
import com.rubyroo.service.DBService;

public class Main {
    public static void main(String[] args) {
        User user = new User("1",18,"1","1","1","1","1","1","1","1","1");
        DBService.insertUser(user);
    }
}
