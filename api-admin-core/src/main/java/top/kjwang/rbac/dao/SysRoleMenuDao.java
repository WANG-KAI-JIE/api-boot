package top.kjwang.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.kjwang.mybatis.dao.BaseDao;
import top.kjwang.rbac.entity.SysRoleMenuEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:39
 * @description SysRoleMenuDao 角色与菜单对应关系 dao
 */

@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
}
