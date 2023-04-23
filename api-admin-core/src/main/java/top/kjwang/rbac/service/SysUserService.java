package top.kjwang.rbac.service;

import top.kjwang.mybatis.service.BaseService;
import top.kjwang.rbac.entity.SysUserEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:57
 * @description SysUserService 系统用户业务接口
 */

public interface SysUserService extends BaseService<SysUserEntity> {
    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

}