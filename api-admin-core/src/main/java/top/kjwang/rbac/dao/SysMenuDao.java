package top.kjwang.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.kjwang.mybatis.dao.BaseDao;
import top.kjwang.rbac.entity.SysMenuEntity;
import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/23 22:38
 * @description SysMenuDao 菜单管理 dao
 */

@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {
    /**
     * 查询所有菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuEntity> getMenuList(@Param("type") Integer type);

    /**
     * 查询用户菜单列表
     *
     * @param userId 用户ID
     * @param type 菜单类型
     */
    List<SysMenuEntity> getUserMenuList(@Param("userId") Long userId, @Param("type") Integer type);

    /**
     * 查询用户权限列表
     * @param userId  用户ID
     */
    List<String> getUserAuthorityList(@Param("userId") Long userId);

    /**
     * 查询所有权限列表
     */
    List<String> getAuthorityList();

}