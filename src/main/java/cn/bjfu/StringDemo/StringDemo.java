package cn.bjfu.StringDemo;

import org.junit.Test;

/**
 * @Auther jxy
 * @Date 2020-07-03
 */
public class StringDemo {
    /**
     * 将一个字符串进行反转，将字符串中部分进行反转，比如"abcdef" 反转成"abfedcg"
     * 方式一：转换为char[]
     */
    public static String reverse(String str,int startIndex,int endIndex){
        if(str!=null||str!="") {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex;x<y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    /**
     *方式二：使用String进行反转
     */
    public static String reverse1(String str,int startIndex,int endIndex){
        if(str!=null||str!="") {
            String reverseStr = str.substring(0, startIndex);
            for(int i=endIndex;i>=startIndex;i--){
                reverseStr+=str.charAt(i);
            }
            reverseStr += str.substring(endIndex+1);
            return reverseStr;
        }
        return null;
    }

    /**
     *方式三：使用StringBuilder进行反转
     */
    public static String reverse2(String str,int startIndex,int endIndex){
        if(str!=null||str!="") {
            StringBuilder sb = new StringBuilder(str.length());
            sb.append(str.substring(0,startIndex));
            for(int i=endIndex;i>=startIndex;i--){
                sb.append(str.charAt(i));
            }
            sb.append(str.substring(endIndex+1));
            return sb.toString();
        }
        return null;
    }
    @Test
    public void testResverse(){
        String str = "abcdefg";
        System.out.println(reverse2(str,2,5));
    }
}
