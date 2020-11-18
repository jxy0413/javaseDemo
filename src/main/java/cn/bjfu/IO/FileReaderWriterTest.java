package cn.bjfu.IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by jxy on 2020/11/17 0017 15:51
 * 一、流的分类
 * 1、操作数据单位：字节流、字符流
 * 2、数据的流向：输入流、输出流
 * 3、流的角色：节点流、处理流
 *
 * 抽象基类       缓冲流(处理流的一种)
 * InputStream     FileInputStream  (read(byte[] cubf))         BufferedInputStream
 * OutputStream    FileOutputStream    (write(byte[] cubf))     BufferedOutputStream
 * Reader          FileReader (read(char[] cubf))               BufferedReader  readLine
 * Writer          FileWriter (write(char[] cbuf,0,len))        BufferedWriter
 */
public class FileReaderWriterTest {
    /**
     * 将hello.txt文件内容读入到程序中，并输出到控制台
     */
    @Test
    public void testFileReader(){
        FileReader fr = null;
        try {
            File file = new File("hello.txt");  //相较于当前Moudle
            fr = new FileReader(file);
            //数据的读入
            try {
                int data ;
                while ((data=fr.read())!=-1){
                    System.out.print((char)data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(fr!=null){
                        fr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对reader()操作升级：reader的重载方法
     */
    @Test
    public void test1(){
        //1.File类实例化
        File file = new File("hello.txt");
        //2.FileReader实例化
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char [] b = new char[1024];
            try {
                int len;
                while ((len=fr.read(b))!=-1){
                    for(int i=0;i<len;i++){
                        System.out.print(b[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1、从内存中写出数据到硬盘的文件里面
     * 2、File对应的硬盘的文件不存在：
     *          使用的构造器 FileWriter(file,false);
     */
    @Test
    public void test2(){
        //1、提供File类的对象，指明写出到的文件
        File file = new File("hello1.txt");
        //2、提供FileWriter的对象，用于数据的写入
        try {
            FileWriter fr = new FileWriter(file,true);
            fr.write("I have a dream !\n");
            fr.write("I have a dream !");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileReaderFileWriter(){
        //创建File类对象
        File srcFile = new File("hello.txt");
        File desFile = new File("hello2.txt");
        FileReader fr =null;
        FileWriter fw =null;
        //创建
        try {
            fr = new FileReader(srcFile);
            fw = new FileWriter(desFile);
            //读入和写出
            char [] cbuf = new char[1024];
            int len;
            while((len=fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fw!=null){
                    fw.close();
                }
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
