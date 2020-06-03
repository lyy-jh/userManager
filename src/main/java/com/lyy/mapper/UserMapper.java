package com.lyy.mapper;

import com.lyy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:com.lyy.mapper
 * @Author:lyy
 * @Date:2020/6/3
 * @version:0.0.0.1
 */
public interface UserMapper {
    @Select("select * from user where username=#{username} and password= #{password}")
    User selByNameAndPassword(User user);

    @Insert("insert into user values(default,#{username},#{password},#{age},#{sex},#{permission},#{isDelete})")
    int insertUser(User user);

    List<User> selUser(User user);

    int updateUser(User user);




}
