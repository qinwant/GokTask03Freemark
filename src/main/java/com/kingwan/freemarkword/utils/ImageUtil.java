package com.kingwan.freemarkword.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kingwan on 2020/12/5.
 * 说明：
 */
public class ImageUtil {
    //MultipartFile转BASE64字符串
    public static String multipartFileToBASE64(MultipartFile file) throws Exception{
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String[] suffixArray=file.getOriginalFilename().split("\\.");
        String preffix="data:image/jpg;base64,".replace("jpg", suffixArray[suffixArray.length - 1]);
        String base64EncoderImg=preffix + base64Encoder.encode(file.getBytes()).replaceAll("[\\s*\t\n\r]", "");
        String encode = base64Encoder.encode(file.getBytes());
//        System.out.println(encode);
//        return base64EncoderImg;
        return encode;
    }

    /**
     *
     * @param imgFile
     * @return
     */
    public static String getImageStr(String imgFile) {

        InputStream in = null;
        byte[] data = null;
        try {
            if(imgFile.startsWith("http")){          //获取在线图片
                URL url = new URL(imgFile);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5 * 1000);
                in = conn.getInputStream();
            }else{      //获取线下图片
                in = new FileInputStream(imgFile);
            }
        /*
　　　　　//使用此种方式在获取在线图片时下载word中图片可能显示不全，其原因就是网络通讯往往是间断性的，一串字节往往分几批进行发送。本地程序调用available()方法有时得到0，这可能是对方还没有响应，也可能是对方已经响 应了，但是数据还没有送达本地。对方发送了1000个字节给你，也许分成3批到达，这你就要调用3次available()方法才能将数据总数全部得到。
　　　　　int count = 0;
        while (count == 0) {
            count = in.available();
        }
        data = new byte[count];*/
            int c;
            ByteArrayOutputStream buff = new ByteArrayOutputStream();
            while((c = in.read()) >= 0){
                buff.write(c);
            }
            data = buff.toByteArray();
            buff.close();
            in.read(data);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        if(data!=null && data.length>0){
            return encoder.encode(data);
        }
        return null;
    }
}
