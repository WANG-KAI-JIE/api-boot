package top.kjwang.rbac.service;

import org.springframework.security.core.userdetails.UserDetails;
import top.kjwang.rbac.entity.SysUserEntity;

/**
 * @author kjwang
 * @date 2023/4/23 23:09
 * @description SysUserDetailsService 用户详细信息接口
 */

public interface SysUserDetailsService {
    /**
     * 获取 UserDetails 对象
     */
    UserDetails getUserDetails(SysUserEntity userEntity);
}
