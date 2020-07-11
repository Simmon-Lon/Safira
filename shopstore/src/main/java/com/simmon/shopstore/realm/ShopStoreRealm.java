package com.simmon.shopstore.realm;

import com.simmon.shopstore.entity.Login;
import com.simmon.shopstore.repository.loginRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopStoreRealm extends AuthorizingRealm {

    @Autowired
    private loginRepository loginRepository;

    /**
     * 认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 授权
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        Login login =loginRepository.findByUsername(token.getUsername());
        if (login !=null){
            return new SimpleAuthenticationInfo(login,login.getLpassword(),getName());
        }
        return null;
    }
}
