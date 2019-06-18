package com.yk.service;


import com.yk.bean.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    User login(String account, String password, HttpSession session);

    void regiter(String account, String password, Integer sex, String nickName, String phone, String email);

    List<User> findAllUser();

    void deleteUserOne(Integer id);

    void updateMessage(Integer id, String account, Integer sex, String nickName, String phone, String email);
}
