package com.yk.controller.api;

import com.yk.bean.User;
import com.yk.service.UserService;
import com.yk.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yk.util.ResponseUtil.success;

@RestController
@RequestMapping("api")
public class IndexApiController {

    @Autowired
    private UserService userService;

    /**
     * 用户列表接口
     * @return
     */
    @GetMapping("/index")
    public ResultVO<List<User>> index(){
        return success(userService.findAllUser());
    }

}
