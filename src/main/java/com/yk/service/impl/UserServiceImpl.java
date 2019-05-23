package com.yk.service.impl;

import com.yk.bean.User;
import com.yk.enums.ResultEnum;
import com.yk.exception.GlobalException;
import com.yk.mapper.UserMapper;
import com.yk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String userName, String password) {
		User user = userMapper.findUserByUserNameAndPassword(userName,password);
		if(user==null){
			log.error("查无此人");
			throw new GlobalException(ResultEnum.NO_USER);
		}
		return user;
	}

	@Override
	public void regiter(String userName, String password, Integer sex,String realName,String phone,String email) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setSex(sex);
		user.setRealName(realName);
		user.setPhone(phone);
		user.setEmail(email);
		userMapper.saveUser(user);
	}

	@Override
	public List<User> findAllUser() {
		List<User> userList = userMapper.getAllUser();
		System.out.println("￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥");
		System.out.println("userlist:"+userList);
		System.out.println("￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥");
		return userList;
	}
}
