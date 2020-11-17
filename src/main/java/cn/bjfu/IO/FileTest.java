package cn.bjfu.IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by jxy on 2020/11/17  11:52
 * 1、File类的一个对象，代表一个文件或者一个目录(俗称：文件夹)
 * 2、File类生命在java.io包下
 * 3、路径分隔符
 */
public class FileTest {
    /**
     * 1.如果创建File类的实例
     *   File(String filePath);
     *   File(String parentPath,String filePath)
     *   File(File file,String path)
     * 2.
     * 相对路径
     * 绝对路径
     * 3.File类中涉及到关于文件或者文件目录的创建、删除、重命名、修改时间、文件大小等方法
     * 并未设计到写入或者读取文件内容的操作，如果需要读取文件内容，必须需要要用IO流
     * 4、后续File类的对象会作为参数传递到流的构造器中，指明读取或者写入的终点
     */
    @Test
    public void test1(){
         //相对于当前moudle
         File file1 = new File("hello.txt");
         File file2 = new File("C:\\Users\\Administrator\\IdeaProjects\\javaseDemo\\hello.txt");
         System.out.println(file1);
         System.out.println(file2);
         //构造器2
         File file3 = new File("C:\\Users\\Administrator\\IdeaProjects\\javaseDemo","hello.txt");
         System.out.println(file3);
         //构造器3
         File file4 = new File(file3,"hi.txt");
         System.out.println(file4);
    }

    /**
     * File类的获取功能
     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
        System.out.println();
        File file2 = new File("C:\\Users\\Administrator\\IdeaProjects\\javaseDemo\\hello.txt");
        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));
    }

    @Test
    public void test3(){
        File file = new File("C:\\Users\\Administrator\\IdeaProjects");
        String[] list = file.list();
        for(String s:list){
            System.out.println(s);
        }
        File[] listFiles = file.listFiles();
        for(File s:listFiles){
            System.out.println(s);
        }
    }

    /**
     * 比如要想保证是成功的，需要file1需要在硬盘中，但file2不能存在
     */
    @Test
    public void test4(){
        File file2 = new File("hello.txt");
        File file1= new File("D:\\hi.txt" );
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
        System.out.println();
        File file2 = new File("D:\\hi.txt");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /**
     *
     */
    @Test
    public void test6(){
        File file = new File("hi.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            file.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test7(){
        //文件的创建
        File file = new File("D:\\hi\\hi1");
        boolean mkdir = file.mkdir();
        if(mkdir){
            System.out.println("创建成功");
        }
        File file2 = new File("D:\\hi\\hi1");
        boolean mkdir1 = file2.mkdirs();
        if(mkdir1){
            System.out.println("创建成功");
        }
    }
}
