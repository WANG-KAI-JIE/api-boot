package top.kjwang.rbac.service.impl;

import org.springframework.stereotype.Service;
import top.kjwang.mybatis.service.impl.BaseServiceImpl;
import top.kjwang.rbac.dao.SysUserRoleDao;
import top.kjwang.rbac.entity.SysUserRoleEntity;
import top.kjwang.rbac.service.SysUserRoleService;
/**
 * @author kjwang
 * @date 2023/4/23 23:01
 * @description SysUserRoleServiceImpl 用户角色关系业务实现类
 */

@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
}