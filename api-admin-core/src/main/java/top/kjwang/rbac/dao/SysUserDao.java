package top.kjwang.rbac.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.kjwang.mybatis.dao.BaseDao;
import top.kjwang.rbac.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * @author kjwang
 * @date 2023/4/23 22:35
 * @description SysUserDao 系统用户管理 dao
 */

@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return SysUserEntity
     */
    default SysUserEntity getByUsername(String username){
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
    }

    /**
     * 根据手机号查找用户
     *
     * @param mobile 手机号
     * @return SysUserEntity
     */
    default SysUserEntity getByMobile(String mobile){
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("mobile",mobile));
    }

    /**
     * 根据条件查询用户数据
     *
     * @param params 参数
     * @return List<SysUserEntity>
     */
    List<SysUserEntity> getList(Map<String,Object> params);

    /**
     * 根据id查询用户信息
     *
     * @param id id
     * @return SysUserEntity
     */
    SysUserEntity getById(@Param("id") Long id);
}