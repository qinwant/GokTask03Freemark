package com.kingwan.freemarkword.utils;

import freemarker.core.ParseException;
import freemarker.log.Logger;
import freemarker.template.*;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kingwan on 2020/12/5.
 * 说明：
 */
public class WordExportUtil {
    private Logger log = Logger.getLogger(WordExportUtil.class.toString());
    private Configuration config = null;

    public WordExportUtil() {
        config = new Configuration(Configuration.VERSION_2_3_28);
        config.setDefaultEncoding("utf-8");
    }
    /**
     * FreeMarker生成Word
     * @param dataMap 数据
     * @param templateName 目标名
     * @param saveFilePath 保存文件路径的全路径名（路径+文件名）
     * @Author Huang Xiaocong 2018年12月15日 下午10:19:03
     */
    public void createWord(Map<String, Object> dataMap, String templateName, String saveFilePath) {
        //加载模板(路径)数据
        config.setClassForTemplateLoading(this.getClass(), "");
        //设置异常处理器 这样的话 即使没有属性也不会出错 如：${list.name}...不会报错
        config.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        Template template = null;
        if(templateName.endsWith(".ftl")) {
            templateName = templateName.substring(0, templateName.indexOf(".ftl"));
        }
        try {
            template = config.getTemplate(templateName + ".ftl");
        } catch (TemplateNotFoundException e) {
            log.error("模板文件未找到", e);
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            log.error("模板类型不正确", e);
            e.printStackTrace();
        } catch (ParseException e) {
            log.error("解析模板出错，请检查模板格式", e);
            e.printStackTrace();
        } catch (IOException e) {
            log.error("IO读取失败", e);
            e.printStackTrace();
        }
        File outFile = new File(saveFilePath);
        if(!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdirs();
        }
        Writer out = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            log.error("输出文件时未找到文件", e);
            e.printStackTrace();
        }
        out = new BufferedWriter(new OutputStreamWriter(fos));
        //将模板中的预先的代码替换为数据
        try {
            template.process(dataMap, out);
        } catch (TemplateException e) {
            log.error("填充模板时异常", e);
            e.printStackTrace();
        } catch (IOException e) {
            log.error("IO读取时异常", e);
            e.printStackTrace();
        }
        log.info("由模板文件：" + templateName + ".ftl" + " 生成文件 ：" + saveFilePath + " 成功！！");
        try {
            out.close();//web项目不可关闭
        } catch (IOException e) {
            log.error("关闭Write对象出错", e);
            e.printStackTrace();
        }
    }
    /**
     * 获得图片的Base64编码
     * @param imgFile
     * @return
     * @Author Huang Xiaocong 2018年12月15日 下午10:15:10
     */
    public String getImageStr(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
        } catch (FileNotFoundException e) {
            log.error("加载图片未找到", e);
            e.printStackTrace();
        }
        try {
            data = new byte[in.available()];
            //注：FileInputStream.available()方法可以从输入流中阻断由下一个方法调用这个输入流中读取的剩余字节数
            in.read(data);
            in.close();
        } catch (IOException e) {
            log.error("IO操作图片错误", e);
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);

    }
    public static void main(String[] args) {
        WordExportUtil emw = new WordExportUtil();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("RsName", "张三");
        dataMap.put("RsPosition","java开发");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());
        System.out.println(format);
        dataMap.put("RsBirthday", format);
//        dataMap.put("RsBirthday", "19990710");
        dataMap.put("RsOrigin", "福建厦门");
        dataMap.put("RsEducation", "厦门大学");
        dataMap.put("RsPhone", "123456789");
        dataMap.put("RsAddress", "思明区东路2号");
        dataMap.put("RsSkill", "CET6");


        emw.createWord(dataMap, "test.ftl", "D:\\tmp\\test\\export.doc");
    }
}
