package cn.bjfu.IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by jxy on 2020/11/18 0018 9:56
 * 其他流的使用
 *
 */
public class OtherStreamTest {
    /**
     * 标准的输入流、输出流
     * System.in:标准的输入流，默认从键盘输出
     * Ststem.out:标准的输出流，默认是控制台输出
     * 可以通过System类 setIn/setOut 重新指定输入/输出
     * ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰成员变量
     */

    public static void main(String[] args) throws Exception{
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        while (true){
            System.out.println("请输入字符串：");
            String data = br.readLine();
            if("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                System.out.println("程序结束");
                break;
            }
            String upperCase = data.toUpperCase();
            System.out.println(upperCase);
        }
        br.close();
    }

    /**
     * 2、打印流
     * 2.1 提供了一系列重载的print()和println()方法
     * 3、数据流
     * 3.1 DataInputStream和DataOutputStream
     * 3.2 用于读取或者写出基本类型数据的变量或者字符串
     * 练习：将内存中的字符串、基本数据类型的变量写出到文件
     * 注意点：读入的顺序要和当初写入文件顺序时，保存的顺序一致！
     */
     @Test
     public void test2() throws Exception{
         DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
         dos.writeUTF("jia");
         dos.writeInt(12);
         dos.writeBoolean(true);
         dos.flush();
         dos.close();
     }

     @Test
     public void test3()throws Exception{
         DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
         String name = dis.readUTF();
         int age = dis.readInt();
         boolean isMale = dis.readBoolean();
         System.out.println(name+":"+age+":"+isMale);
     }

    /**
     * 对象流的使用
     * 序列化过程：将内存中的java对象保存到磁盘中或者通过网络传出过去
     * 使用ObjectOutputStream来实现
     * 需要实现接口：Serializable
     * 除了当前Person类需要实现Serializable接口之外，还必须保证其内部也是可序列化的
     */
     @Test
     public void testObjectOutputStream()throws Exception{
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("object.dat")));
         oos.writeObject(new String("我爱北京天安门"));
         oos.flush(); //刷新操作
         oos.writeObject(new Person("jiaxiangyu",24,new Account()));
         oos.flush();
         oos.close();
     }

    /**
     * 反序列化
     * @throws Exception
     * 使用ObjectInputStream
     */
     @Test
     public void testObjectInputStream()throws Exception{
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
         Object obj = ois.readObject();
         System.out.println(obj);
         Object objStu = ois.readObject();
         System.out.println(objStu);
         ois.close();
     }
}
