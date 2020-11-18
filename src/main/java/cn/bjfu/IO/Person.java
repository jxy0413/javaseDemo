package cn.bjfu.IO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by jxy on 2020/11/18 0018 12:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    //public static final long serialVersionUID = 4564648494934646L;
    private static final long serialVersionUID = -6849794470722667710L;
    private String name;
    private int age;
    private Account account;
}

class Account implements Serializable{
    private int id;
}