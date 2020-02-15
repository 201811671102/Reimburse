package com.cs.shiro;

import com.cs.pojo.User;
import com.cs.redis.RedisUtil;
import com.cs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    private RedisUtil redisUtil;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
       //user.getType() 0 学生  1 职工
        info.addStringPermission(user.getType().toString());
        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken)
            throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = new User();
        Integer type = -1;
        if (!redisUtil.hHasKey(token.getUsername(),token.getPassword().toString())){
            user = userService.getUserByAccount(token.getUsername());
            if (user == null){
                return null;
                //shiro底层抛出UnKonwAccountException
            }
        }else{
             type = (Integer) redisUtil.hget(token.getUsername(),token.getPassword().toString());
        }
        user.setAccount(token.getUsername());
        user.setPassword(token.getPassword().toString());
        user.setType(type);
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
