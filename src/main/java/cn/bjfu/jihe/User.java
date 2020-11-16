package cn.bjfu.jihe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jxy on 2020/11/16 0016 9:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable{
    private String name;
    private int age;

    //按照姓名从小到大排列
    public int compareTo(Object o) {
        if(o instanceof User){
            User user =(User)o;
            int compare = this.name.compareTo(user.name);
            if(compare!=0){
                return compare;
            }else{
                return Integer.compare(this.age,((User) o).age);
            }
        }
        return 0;
    }
}
