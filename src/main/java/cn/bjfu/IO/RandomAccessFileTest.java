package cn.bjfu.IO;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by jxy on 2020/11/18 15:11
 * 直接继承于 java.lang.Object类
 * 既可以作为输入流，又可以作出输出流
 */
public class RandomAccessFileTest {
    @Test
    public void test1()throws Exception{
        RandomAccessFile raf1 = new RandomAccessFile(new File("11.jpg"),"r");
        RandomAccessFile raf2 = new RandomAccessFile(new File("13.jpg"),"rw");
        byte[] buffer = new byte[1024];
        int len;
        while ((len=raf1.read(buffer))!=-1){
            raf2.write(buffer,0,len);
        }
    }
    //如果RandomAccessFile作为输出流时，写出到文件不存在，则执行过程中自动创建
    //如果存在 从头开始覆盖
    @Test
    public void test2()throws Exception{
        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");
        raf1.seek(3);
        raf1.write("jiaxiangyu".getBytes());
        raf1.close();
    }

    /**
     * 使用RandomAceessFile实现插入效果
     */
    @Test
    public void test3()throws Exception{
        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");
        raf1.seek(3);
        StringBuilder sb = new StringBuilder(new File("hello.txt").length()+"");
        byte[] buffer = new byte[20];
        int len;
        while ((len=raf1.read(buffer))!=-1){
            sb.append(new String(buffer,0,len));
        }
        //调回指针
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.write(buffer.toString().getBytes());

    }
}
