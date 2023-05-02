package top.kjwang.rbac.service;


import top.kjwang.common.utils.PageResult;
import top.kjwang.mybatis.service.BaseService;
import top.kjwang.rbac.entity.SysMenuEntity;
import top.kjwang.rbac.query.SysMenuQuery;
import top.kjwang.rbac.vo.SysMenuVO;
import top.kjwang.security.user.UserDetail;

import java.util.List;
import java.util.Set;
/**
 * @author kjwang
 * @date 2023/4/23 23:04
 * @description SysMenuService 系统菜单业务接口
 */




/**
 * 系统菜单业务接口
 *
 * @author mqxu
 */
public interface SysMenuService extends BaseService<SysMenuEntity> {
    /**
     * 菜单列表
     *
     * @param type 菜单类型
     */
    List<SysMenuVO> getMenuList(Integer type);

    /**
     * 菜单分页
     *
     * @param query 查询参数
     */
    PageResult<SysMenuVO> page(SysMenuQuery query);

    /**
     * 用户菜单列表
     *
     * @param user 用户
     * @param type 菜单类型
     */
    List<SysMenuVO> getUserMenuList(UserDetail user, Integer type);

    /**
     * 获取子菜单的数量
     * @param pid  父菜单ID
     */
    Long getSubMenuCount(Long pid);

    /**
     * 获取用户权限列表
     */
    Set<String> getUserAuthority(UserDetail user);

    void save(SysMenuVO vo);

    void update(SysMenuVO vo);

    void delete(Long id);
}


