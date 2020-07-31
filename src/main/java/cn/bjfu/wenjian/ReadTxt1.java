package cn.bjfu.wenjian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Auther jxy
 * @Date 2020-06-23
 */
public class ReadTxt1 {
    public static String readTxt(String path) {
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append("\n" + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = readTxt("/Users/jiaxiangyu/Desktop/info.txt");
        String[] s1 = s.split("\n");
        for(int i=1;i<s1.length;i++){
            String s2 = s1[i];
            String[] s3 = s2.split("nobody");
            String trim = s3[1].trim();
//            System.out.println(trim);
            //System.out.println(trim);
            String[] s4 = trim.split(" ");
            StringBuffer sb = new StringBuffer();
            sb.append(s4[4]);
            System.out.println(sb);

            //System.out.println(s4[4]);
        }
    }
}
