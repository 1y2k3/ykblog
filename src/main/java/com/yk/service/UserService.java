package com.yk.service;


import com.yk.bean.User;

import java.util.List;

public interface UserService {

    User login(String userName, String password);

    void regiter(String userName, String password, Integer sex, String realName, String phone, String email);

    List<User> findAllUser();
}
