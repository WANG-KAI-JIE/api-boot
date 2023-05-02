package top.kjwang.rbac.service;

import top.kjwang.mybatis.service.BaseService;
import top.kjwang.rbac.entity.SysUserRoleEntity;
import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/23 23:00
 * @description SysUserRoleService 用户角色关系业务接口
 */

public interface SysUserRoleService extends BaseService<SysUserRoleEntity> {
    /**
     * 保存或修改
     *
     * @param userId     用户ID
     * @param roleIdList 角色ID列表
     */
    void saveOrUpdate(Long userId, List<Long> roleIdList);

    /**
     * 分配角色给用户列表
     *
     * @param roleId     角色ID
     * @param userIdList 用户ID列表
     */
    void saveUserList(Long roleId, List<Long> userIdList);

    /**
     * 根据角色id列表，删除用户角色关系
     *
     * @param roleIdList 角色id
     */
    void deleteByRoleIdList(List<Long> roleIdList);

    /**
     * 根据用户id列表，删除用户角色关系
     *
     * @param userIdList 用户id列表
     */
    void deleteByUserIdList(List<Long> userIdList);

    /**
     * 根据角色id、用户id列表，删除用户角色关系
     *
     * @param roleId     角色id
     * @param userIdList 用户id列表
     */
    void deleteByUserIdList(Long roleId, List<Long> userIdList);

    /**
     * 角色ID列表
     *
     * @param userId 用户ID
     */
    List<Long> getRoleIdList(Long userId);
}