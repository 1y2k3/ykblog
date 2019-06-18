package com.yk.controller.api;

import com.yk.bean.User;
import com.yk.service.UserService;
import com.yk.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
    public ResultVO<User> login(String account, String password, HttpSession session) {
        return success(userService.login(account, password, session));
    }



    @PostMapping("/logout")
    public ResultVO logout(HttpSession session){
        session.removeAttribute("user");
        return success();
    }


    /**
     * 注册接口
     *
     * @param account
     * @param password
     * @param sex
     * @return
     */
    @PostMapping("/register")
    public ResultVO register(String account, String password, Integer sex, String nickName, String phone, String email) {
        userService.regiter(account, password, sex, nickName, phone, email);
        return success();
    }

    /**
     * 返回用户列表页面
     *
     * @return
     */
    @GetMapping("/list")
    public ResultVO userList() {
        return success(userService.findAllUser());
    }


    /**
     * 删除用户接口
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public ResultVO deleteUser(Integer id) {
        userService.deleteUserOne(id);
        return success();
    }



    /**
     * 修改信息接口
     *
     * @param account
     * @param sex
     * @param nickName
     * @param phone
     * @param email
     * @return
     */

    @PostMapping("/update")
    public ResultVO updateMessage(Integer id, String account, Integer sex, String nickName, String phone, String email) {
        userService.updateMessage(id, account, sex, nickName, phone, email);
        return success();
    }

}
