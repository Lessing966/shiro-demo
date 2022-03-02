package com.example.demo.modules.controller;

import com.example.demo.common.utils.ShiroUtils;
import com.example.demo.modules.entity.LoginEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys")
public class TestController {


    @RequestMapping("/test")
    public void test() {
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            System.out.println("登录成功....");
        } catch (UnknownAccountException e) {
            System.out.println("账号错误...");
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误...");
        }
        System.out.println(subject.isAuthenticated());
        LoginEntity user = ShiroUtils.getUser();
        System.out.println(user);
        String host = subject.getSession().getHost();
        System.out.println(host);
    }


    @RequestMapping("/bbb")
    @RequiresPermissions("zdyl:test:1")
    public void bbb() {
        System.out.println("bbbbbbbbbbbbbbb");
        System.out.println("bbbbbbbbbbbbbbb");
    }

    @RequestMapping("/ccc")
    @RequiresPermissions("zdyl:test:2")
    public void ccc() {
        System.out.println("cccccccccccc");
    }

}