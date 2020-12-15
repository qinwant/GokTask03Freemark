package com.kingwan.freemarkword.controller;

import com.kingwan.freemarkword.utils.ImageUtil;
import com.kingwan.freemarkword.utils.WordExportUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kingwan on 2020/12/5.
 * 说明：
 */
@Controller
public class TestController {
    @PostMapping("/test-demo/uploadImage")
    @ResponseBody
    public String test(MultipartFile file) throws Exception {
//        System.out.println(file);
        String s = ImageUtil.multipartFileToBASE64(file);
//        System.out.println(s);
        WordExportUtil emw = new WordExportUtil();
//        String imageStr = ImageUtil.getImageStr("https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201127215822.png");
        String imageStr = ImageUtil.getImageStr("https://i.loli.net/2020/08/16/CpafRrILhjASONF.png");
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("RsImage", imageStr);

        emw.createWord(dataMap, "pic.ftl", "D:\\tmp\\test\\export.doc");
        return s;
    }
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("welcome","hello fishpro");
        return "index";
    }
}
