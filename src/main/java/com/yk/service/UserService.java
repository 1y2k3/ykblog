package com.yk.service;


import com.yk.bean.User;

import java.util.List;

public interface UserService {

    User login(String account, String password);

    void regiter(String account, String password, Integer sex, String nickName, String phone, String email);

    List<User> findAllUser();
}
