package cn.bjfu.StringDemo;

import org.junit.Test;

/**
 * @Auther jxy
 * @Date 2020-07-03
 */
public class StringDemo2 {
    /**
     * 获取一个字符串在你另一个字符串中出现的次数
     *
     */
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index;
        if(subLength>mainLength){
            return 0;
        }else{

            while ((index=mainStr.indexOf(subStr))!=-1){
                count++;
                mainStr = mainStr.substring(index+subStr.length());
            }
            return count;
        }
    }


    /**
     * 获取两个字符串中最大相同字串
     */
    public String getMaxSameString(String str1,String str2){
          String maxStr = (str1.length()>=str2.length())? str1:str2;
          String minStr = (str1.length()<str2.length())? str1:str2;
          int length = minStr.length();
          for(int i=0;i<length;i++){
              for(int x=0,y=length-i;y<=length;x++,y++){
                  String substring = minStr.substring(x,y);
                  if(maxStr.contains(minStr)){
                      return substring;
                  }
              }
          }
          return null;
    }
    /**
     *获取两个字符串中最大相同子串
     */
    @Test
    public String getMaxSubString1(String str,String str1){
        String maxStr = (str.length()>=str1.length())?str:str1;
        String minStr = (str.length()<str1.length())?str:str1;
        int length = minStr.length();
        for(int i=0;i<length;i++){
            for(int x=0,y=str.length()-i;y<=length;x++,y++){
                String substring = minStr.substring(x, y);
                if(maxStr.contains(minStr)){
                    return substring;
                }
            }
        }
        return null;
    }

    @Test
    public void test1(){
        String mainStr="abcaadfafhelloadfaaababab";
        String subStr="hello";
        String maxSameString = getMaxSameString(mainStr, subStr);
        System.out.println(maxSameString);
    }

    @Test
    public void test(){
        String mainStr="abcaadfafadfaaababab";
        String subStr="ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }
}
