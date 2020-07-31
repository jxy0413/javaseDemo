package cn.bjfu.StringDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Auther jxy
 * @Date 2020-07-05
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Comparable{
    private String name;
    private double price;

    //指明商品比较大小的方式 先按照价格从低 再按照名称来排序
    public int compareTo(Object o) {
       if(o instanceof Goods){
           Goods goods =(Goods)o;
           if(this.price>goods.price){
               return 1;
           }else if(this.price<goods.price){
               return -1;
           }else{
               //return 0;
              return this.name.compareTo(goods.name);
           }
       }
       throw  new RuntimeException("传入的数据类型不一致");
    }
}
