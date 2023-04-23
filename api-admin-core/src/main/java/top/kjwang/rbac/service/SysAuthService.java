package top.kjwang.rbac.service;

import top.kjwang.rbac.vo.SysAccountLoginVO;
import top.kjwang.rbac.vo.SysTokenVO;

/**
 * @author kjwang
 * @date 2023/4/23 22:52
 * @description SysAuthService 权限认证服务
 */

public interface SysAuthService {
    /**
     * 账号密码登录
     *
     * @param login 登录信息
     */
    SysTokenVO loginByAccount(SysAccountLoginVO login);

    /**
     * 退出登录
     *
     * @param accessToken accessToken
     */
    void logout(String accessToken);
}
