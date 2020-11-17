package cn.bjfu.IO;

import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jxy on 2020/11/17 0017 18:32
 */
public class FileInputOutputStreamTest {
    /**
     * 实现对图片的复制操作
     */
    public void testInputOutputStream(String src,String desc){
        File srcFile = new File(src);
        File descFile = new File(desc);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);
            byte b [] = new byte[1024];
            int len;
            while((len=fis.read(b))!=-1){
                fos.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        testInputOutputStream("F:\\wsy\\1\\1.mp4","F:\\999.mp4");
        long end = System.currentTimeMillis();
        //复制的时间为:1566
        System.out.println("复制的时间为:"+(end-start));
    }
}
