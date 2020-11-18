package cn.bjfu.IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by jxy on 2020/11/17 0017 22:27
 * 处理流之二：转换流的使用
 * 1、转换流：
 *        InputStreamReader ： 将一个字节的输入流转换为字符的输入流
 *        OutputStreamWriter： 将一个字符的输出流转换为字节的输出流
 * 2、提供字节流和字符流之间的转换
 *    解码：字节、字节数组 ---》字符数组、字符串
 *    编码：字符数组、字符串 ---》字节、字节数组
 * 3、字符集
 * ASCII:美国标准信息交换码。 一个字节的7位
 * ISO8859-1:拉丁码表  一个字节的8位
 * GB2312:中国中文编码表
 * GBK:中国的中文编码表升级
 * Unicode:国际标准码 全世界所有的码 每一个数字都有    所有的文字都可以用两个字节表示
 * UTF-8:变长的编码方式  4个字节   最新的话可能是6个字节
 */
public class InputStreamReaderTest {
      @Test
      public void test()throws Exception{

          FileInputStream fis = null;
          InputStreamReader isr = null;
          try {
              fis = new FileInputStream(new File("hello.txt"));
              try {
                   isr = new InputStreamReader(fis,"UTF-8");
                   char [] c = new char[20];
                   int len;
                   while((len=isr.read(c))!=-1){
                       String str = new String(c,0,len);
                       System.out.println(str);
                   }
              } catch (UnsupportedEncodingException e) {
                  e.printStackTrace();
              }
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          }
      }

      @Test
      public void test2()throws Exception{
          File file1 = new File("hello1.txt");
          File file2 = new File("hellogbk.txt");

          FileInputStream fis = new FileInputStream(file1);
          FileOutputStream fos = new FileOutputStream(file2);

          InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
          OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");

          char [] c = new char[20];
          int len;
          while((len=isr.read(c))!=-1){
              osw.write(c,0,len);
          }
          isr.close();
          osw.close();
      }
}
