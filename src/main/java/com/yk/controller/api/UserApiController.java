package com.yk.controller.api;

import com.yk.bean.User;
import com.yk.service.UserService;
import com.yk.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.yk.util.ResponseUtil.*;
import static com.yk.util.ResponseUtil.success;

@RestController
@RequestMapping("api/user")
public class UserApiController {

    @Autowired
    private UserService userService;

    /**
     * 登录接口
     *
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResultVO<User> login(String userName, String password) {
        return success(userService.login(userName,password));
    }


    /**
     * 注册接口
     * @param userName
     * @param password
     * @param sex
     * @return
     */
    @PostMapping("/register")
    public ResultVO register(String userName, String password, Integer sex,String realName,String phone,String email) {
        userService.regiter(userName,password,sex,realName,phone,email);
        return success();
    }
}
