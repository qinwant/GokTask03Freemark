package com.kingwan.freemarkword.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

/**
 * Created by kingwan on 2020/12/5.
 * 说明：
 */
public class WordUtil {
    public static Configuration getConfiguration(){
        //创建配置实例
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        //设置编码
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(WordUtil.class, "/templates");
        return configuration;
    }

    /**
     * 生成doc文件
     *
     * @param ftlFileName 模板ftl文件的名称
     * @param params      动态传入的数据参数
     * @param outFilePath 生成的最终doc文件的保存完整路径
     */
    public void ftlToDoc(String ftlFileName, Map params, String outFilePath) {
        try {
            /** 加载模板文件 **/
            Template template = getConfiguration().getTemplate(ftlFileName);
            /** 指定输出word文件的路径 **/
            File docFile = new File(outFilePath);
            FileOutputStream fos = new FileOutputStream(docFile);
            Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            template.process(params, bufferedWriter);
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
