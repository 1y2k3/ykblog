package com.yk.mapper;


import com.yk.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User findUserByUserNameAndPassword(@Param("account") String account, @Param("password") String password);

    void saveUser(User user);

    List<User> getAllUser();

    void deleteUser(Integer id);

    void updateUser(User user);
}
