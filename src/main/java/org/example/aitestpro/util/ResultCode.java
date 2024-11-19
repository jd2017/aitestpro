package org.example.aitestpro.util;

public interface ResultCode {
    static Integer SUCCESS =0;
    static Integer ERROR =1;

    static Integer UNREGISTER = 40013; //用户未注册
    static Integer PWDWRONG = 40014; //密码错误
}
