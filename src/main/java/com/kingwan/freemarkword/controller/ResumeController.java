package com.kingwan.freemarkword.controller;

import com.kingwan.freemarkword.pojo.BaseResume;
import com.kingwan.freemarkword.utils.ImageUtil;
import com.kingwan.freemarkword.utils.WordExportUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kingwan on 2020/12/6.
 * 说明：
 */
@Controller
public class ResumeController {
    @PostMapping("/createResume")
    @ResponseBody
    public String CreateResume(BaseResume baseResume){
        System.out.println(baseResume);
        //信息验证
        //组装模板
        String imageStr = ImageUtil.getImageStr(baseResume.getRsPicUrl());
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("RsImage", imageStr);
        dataMap.put("RsName", baseResume.getRsName());
        dataMap.put("RsBirthday", baseResume.getRsBirthday());
//        dataMap.put("RsImage", baseResume.getRsPicUrl());
        dataMap.put("RsAddress", baseResume.getRsAddress());
        dataMap.put("RsEducation", baseResume.getRsEducation());
        dataMap.put("RsNative", baseResume.getRsNative());
        dataMap.put("RsPosition", baseResume.getRsPosition());
        WordExportUtil emw = new WordExportUtil();
        emw.createWord(dataMap, "简历-简约白.ftl", "D:\\tmp\\test\\export.doc");
        //保存输出
        return "success";
    }
}
