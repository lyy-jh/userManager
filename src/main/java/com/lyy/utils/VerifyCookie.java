package com.lyy.utils;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Description:com.lyy.utils
 * @Author:lyy
 * @Date:2020/6/3
 * @version:0.0.0.1
 */

public class VerifyCookie {
    public static Boolean verify(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return false;
        }

        for(Cookie cookie : cookies){
            if(cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")){
                return true;
            }
        }
        return false;


    }
}
