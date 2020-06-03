package com.lyy.model;
import lombok.Data;

/**
 * @Description:com.lyy.model
 * @Author:lyy
 * @Date:2020/6/3
 * @version:0.0.0.1
 */


@Data
public class User {
    private int id ;
    private String username;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;
}
