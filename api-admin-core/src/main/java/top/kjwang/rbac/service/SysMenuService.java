package top.kjwang.rbac.service;

import top.kjwang.mybatis.service.BaseService;
import top.kjwang.rbac.entity.SysMenuEntity;
import top.kjwang.rbac.vo.SysMenuVO;
import top.kjwang.security.user.UserDetail;
import java.util.List;
import java.util.Set;
/**
 * @author kjwang
 * @date 2023/4/23 23:04
 * @description SysMenuService 系统菜单业务接口
 */

public interface SysMenuService extends BaseService<SysMenuEntity> {
    /**
     * 菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 用户菜单列表
     *
     * @param user 用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    /**
     * 获取用户权限列表
     */
    Set<String> getUserAuthority(UserDetail user);
}

