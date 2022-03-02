package com.example.demo.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.modules.dao.LoginDao;
import com.example.demo.modules.entity.LoginEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 4 自定义realm
 */
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    private LoginDao loginDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进来了授权");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermission("zdyl:test:1");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进来了认证");
        UsernamePasswordToken jwtToken = (UsernamePasswordToken) authenticationToken;
        String username = jwtToken.getUsername();
        LoginEntity username1 = loginDao.selectOne(new QueryWrapper<LoginEntity>().eq("loginname", username));
        // 如果查询到返回认证信息AuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username1, username1.getPassword(), this.getName());
        return simpleAuthenticationInfo;
    }

}
