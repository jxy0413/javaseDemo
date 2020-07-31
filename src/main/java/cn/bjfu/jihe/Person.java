package cn.bjfu.jihe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Auther jxy
 * @Date 2020-07-20
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
}
