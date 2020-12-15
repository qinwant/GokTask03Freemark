package com.kingwan.freemarkword.controller;

import com.kingwan.freemarkword.utils.ImageUtil;
import com.kingwan.freemarkword.utils.WordExportUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kingwan on 2020/12/6.
 * 说明：
 */
public class Test {
    public static void main(String[] args) {
        WordExportUtil emw = new WordExportUtil();
        String imageStr = ImageUtil.getImageStr("http://img.netbian.com/file/2020/1129/smallb41de5bdc0becb3f1f97855f4d31475e1606663301.jpg");
//        String imageStr = ImageUtil.getImageStr("https://cdn.jsdelivr.net/gh/qinwant/Figurebed/img/20201127215822.png");
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("RsImage", imageStr);

        emw.createWord(dataMap, "pic.ftl", "D:\\tmp\\test\\export.doc");
    }
}
