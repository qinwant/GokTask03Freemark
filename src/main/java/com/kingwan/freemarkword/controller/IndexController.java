package com.kingwan.freemarkword.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kingwan on 2020/12/6.
 * 说明：
 */
@Controller
public class IndexController {
    @GetMapping({"/index","/",""})
    public String index(Model modelMap){
//        modelMap.addAttribute("msg","文件上传下载");
        return "index";
    }
    @GetMapping("/resume")
    public String resume(Model modelMap){
//        modelMap.addAttribute("msg","文件上传下载");
        return "resume";
    }
    @GetMapping("/test")
    public String test(Model modelMap){
//        modelMap.addAttribute("msg","文件上传下载");
        return "test";
    }
}
