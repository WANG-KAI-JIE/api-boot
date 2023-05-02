package top.kjwang.rbac.dao;

/**
 * @author kjwang
 * @date 2023/4/23 22:38
 * @description SysUserRoleDao 用户角色关系 dao
 */

import org.apache.ibatis.annotations.Mapper;
import top.kjwang.mybatis.dao.BaseDao;
import top.kjwang.rbac.entity.SysUserRoleEntity;

import java.util.List;

@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {

	List<Long> getRoleIdList(Long userId);
}