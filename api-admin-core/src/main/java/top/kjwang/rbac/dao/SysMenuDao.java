package top.kjwang.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.kjwang.mybatis.dao.BaseDao;
import top.kjwang.rbac.entity.SysMenuEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:38
 * @description SysMenuDao 菜单管理 dao
 */

@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

}