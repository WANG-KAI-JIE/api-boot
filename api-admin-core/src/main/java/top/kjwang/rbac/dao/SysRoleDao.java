package top.kjwang.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.kjwang.mybatis.dao.BaseDao;
import top.kjwang.rbac.entity.SysRoleEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:37
 * @description SysRoleDao 角色管理 dao
 */

@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

}
