package com.yk.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("web")
@Controller


public class IndexWebController {
    /**
     * 返回主页页面
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
