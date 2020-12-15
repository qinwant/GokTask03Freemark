package com.kingwan.freemarkword.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by kingwan on 2020/12/7.
 * 说明：处理图片工具类
 */
public class ImagesUtil {
    /**
     * MultipartFile转BASE64字符串
     * @param file
     * @return
     * @throws IOException
     */
    public static String multipartFileToBASE64(MultipartFile file) throws IOException {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String base64 = base64Encoder.encode(file.getBytes());
        return base64;
    }

    /**
     * 图片地址转base64字符串
     * @param imgUrl
     * @return
     */
    public static String getImageStr(String imgUrl){
        InputStream in = null;
        byte[] bytes = null;
        try {
            if(imgUrl.startsWith("http")){
                //1. 判断是否为网络地址
                URL url = new URL(imgUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5*100);//设置超时时间
                in = connection.getInputStream();
            }else {
                //2. 本地图片地址
                in = new FileInputStream(imgUrl);
            }
            int c;
            ByteArrayOutputStream buff = new ByteArrayOutputStream();
            while((c = in.read()) >= 0){
                buff.write(c);
            }
            bytes = buff.toByteArray();
            buff.close();
            in.read(bytes);
            in.close();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3. 转base64
        BASE64Encoder encoder = new BASE64Encoder();
        if(bytes!=null && bytes.length>0){
            return encoder.encode(bytes);
        }
        return null;
    }
}
