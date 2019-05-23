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
     * @param account
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResultVO<User> login(String account, String password) {
        return success(userService.login(account,password));
    }


    /**
     * 注册接口
     * @param account
     * @param password
     * @param sex
     * @return
     */
    @PostMapping("/register")
    public ResultVO register(String account, String password, Integer sex,String nickName,String phone,String email) {
        userService.regiter(account,password,sex,nickName,phone,email);
        return success();
    }
}
