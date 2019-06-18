package com.yk.service.impl;

import com.yk.bean.User;
import com.yk.enums.ResultEnum;
import com.yk.exception.GlobalException;
import com.yk.mapper.UserMapper;
import com.yk.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String account, String password, HttpSession session) {
		User user = userMapper.findUserByUserNameAndPassword(account,password);
		session.setAttribute("user",user);
		if(user==null){
			log.error("查无此人");
			throw new GlobalException(ResultEnum.NO_USER);
		}
		return user;
	}

	@Override
	public void regiter(String account, String password, Integer sex,String nickName,String phone,String email) {
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setSex(sex);
		user.setNickName(nickName);
		user.setPhone(phone);
		user.setEmail(email);
		userMapper.saveUser(user);
	}

	@Override
	public List<User> findAllUser() {
		List<User> userList = userMapper.getAllUser();
		return userList;
	}

	@Override
	public void deleteUserOne(Integer id) {
		userMapper.deleteUser(id);
	}

	@Override
	public void updateMessage(Integer id,String account, Integer sex, String nickName, String phone, String email) {
		User user = new User();
		user.setId(id);
		user.setAccount(account);
		user.setSex(sex);
		user.setNickName(nickName);
		user.setPhone(phone);
		user.setEmail(email);
		userMapper.updateUser(user);
	}
}
