package top.kjwang.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.kjwang.mybatis.service.impl.BaseServiceImpl;
import top.kjwang.rbac.dao.SysRoleDao;
import top.kjwang.rbac.entity.SysRoleEntity;
import top.kjwang.rbac.service.SysRoleService;

/**
 * @author kjwang
 * @date 2023/4/23 22:59
 * @description SysRoleServiceImpl 系统角色业务实现类
 */

@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

}