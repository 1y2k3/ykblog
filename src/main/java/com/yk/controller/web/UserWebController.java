package com.yk.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("web/user")
@Controller
public class UserWebController {

    /**
     * 返回登录页面
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    /**
     * 返回注册页面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }


    /**
     * 返回用户列表页面
     * @return
     */
    @GetMapping("/list")
    public String userList(){
        return "user/list";
    }
}
