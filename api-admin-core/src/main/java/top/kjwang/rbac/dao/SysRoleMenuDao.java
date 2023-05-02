package top.kjwang.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.kjwang.mybatis.dao.BaseDao;
import top.kjwang.rbac.entity.SysRoleMenuEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:39
 * @description SysRoleMenuDao 角色与菜单对应关系 dao
 */


import java.util.List;

@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> getMenuIdList(@Param("roleId") Long roleId);
}
