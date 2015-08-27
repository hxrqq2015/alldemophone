package cn.com.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 转换流工具
 * Created by admin on 2015/8/17.
 */
public class StreamTool  {
    /**
     * 解析输入流为字符串
     * @param is
     * @return 解析好的字符串
     */
    public static String readStream(InputStream is){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StringBuilder stringBuilder = new StringBuilder();
        String str=null;
        try {
            byte[] bytes = new byte[1024];
            int len =0;
            while ((len=is.read(bytes))!=-1){
                stringBuilder.append(new String(bytes,0,len));
                bos.write(bytes,0,len);
            }
            is.close();
            str = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
