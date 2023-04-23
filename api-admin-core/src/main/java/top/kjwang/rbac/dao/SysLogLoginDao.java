package top.kjwang.rbac.dao;

import org.apache.ibatis.annotations.Mapper;
import top.kjwang.mybatis.dao.BaseDao;
import top.kjwang.rbac.entity.SysLogLoginEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:40
 * @description SysLogLoginDao 登录日志 dao
 */

@Mapper
public interface SysLogLoginDao extends BaseDao<SysLogLoginEntity> {

}
