package top.kjwang.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.kjwang.rbac.service.SysAuthService;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import top.kjwang.common.exception.ServerException;
import top.kjwang.rbac.service.SysAuthService;
import top.kjwang.rbac.service.SysCaptchaService;
import top.kjwang.rbac.vo.SysAccountLoginVO;
import top.kjwang.rbac.vo.SysTokenVO;
import top.kjwang.security.cache.TokenStoreCache;
import top.kjwang.security.user.UserDetail;
import top.kjwang.security.utils.TokenUtils;

/**
 * @author kjwang
 * @date 2023/4/23 22:42
 * @description SysAuthServiceImpl 权限认证服务实现类
 */

@Service
@AllArgsConstructor
public class SysAuthServiceImpl implements SysAuthService {
    private final TokenStoreCache tokenStoreCache;
    private final AuthenticationManager authenticationManager;
    private final SysCaptchaService sysCaptchaService;

    @Override
    public SysTokenVO loginByAccount(SysAccountLoginVO login) {
        // 如果不需要验证码，可以在这里去掉
//        boolean flag = sysCaptchaService.validate(login.getKey(),login.getCaptcha());
//        if (!flag){
//            throw new ServerException("验证码错误");
//        }
        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ServerException("用户名或密码错误");
        }

        // 用户信息
        UserDetail user = (UserDetail) authentication.getPrincipal();

        // 生成 accessToken
        String accessToken = TokenUtils.generator();

        // 保存用户信息到缓存，accessToken默认过期时间为24小时
        tokenStoreCache.saveUser(accessToken, user);

        return new SysTokenVO(accessToken);
    }

    @Override
    public void logout(String accessToken) {
        // 获取用户信息
        UserDetail user = tokenStoreCache.getUser(accessToken);
        // 从缓存中删除用户
        tokenStoreCache.deleteUser(accessToken);
    }
}
