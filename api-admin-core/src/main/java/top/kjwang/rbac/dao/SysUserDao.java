package top.kjwang.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import top.kjwang.mybatis.dao.BaseDao;
import top.kjwang.rbac.entity.SysUserEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:35
 * @description SysUserDao 系统用户管理 dao
 */

@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
    default SysUserEntity getByUsername(String username){
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
    }
}