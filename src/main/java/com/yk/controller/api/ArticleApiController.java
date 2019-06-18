package com.yk.controller.api;

import com.yk.service.AritcleService;
import com.yk.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.yk.util.ResponseUtil.success;

/**
 * @Auther: chaizi
 */

@RestController
@RequestMapping("api/article")
public class ArticleApiController {
    @Autowired
    private AritcleService aritcleService;

    @GetMapping("/list")
    public ResultVO articleList() {

        return success(aritcleService.findAllArticle());
    }

    @PostMapping("/addArticle")
    public ResultVO addArticle(String title, String content, HttpSession session) {
        System.out.println("2222222222222222" + session.getAttribute("user") + "22222222222222222");
        aritcleService.addArticle(title, content, session);

        return success();
    }

    @PostMapping("/uploadImage")
    public ResultVO uploadImage(MultipartFile file) throws Exception {
        /**
         * 1.初始化文件名
         */
        String fileName = System.currentTimeMillis() + "." + file.getOriginalFilename().split("\\.")[1];
        /**
         * 2.创建文件夹--如果不存在
         */
        String filePath = "/Users/chaizi/Desktop/tmp/";
        File dest = new File(filePath);
        if (!dest.exists()) {
            dest.mkdir();
        }
        /**
         * 3.输出文件到本地
         */
        String newFiles = filePath + fileName;
        FileOutputStream fos = new FileOutputStream(new File(newFiles));
        fos.write(file.getBytes());
        fos.close();
        /**
         * 4.组装并返回数据到前端
         */
        Map<String, String> map = new HashMap<>();
        map.put("src", "../../tmp/" + fileName);
        map.put("title", file.getOriginalFilename());
        return success(map);
    }

    /**
     * 删除文章接口
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public ResultVO deleteArticle(Integer id) {
        aritcleService.deleteArticle(id);
        return success();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/show")
    public ResultVO showArticle(Integer id) {
        return success(aritcleService.showArticle(id));
    }
}
