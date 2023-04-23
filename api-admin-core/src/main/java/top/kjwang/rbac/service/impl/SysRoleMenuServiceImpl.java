package top.kjwang.rbac.service.impl;

import org.springframework.stereotype.Service;
import top.kjwang.mybatis.service.impl.BaseServiceImpl;
import top.kjwang.rbac.dao.SysRoleMenuDao;
import top.kjwang.rbac.entity.SysRoleMenuEntity;
import top.kjwang.rbac.service.SysRoleMenuService;


/**
 * @author kjwang
 * @date 2023/4/23 23:06
 * @description SysRoleMenuServiceImpl 角色与菜单对应业务实现类
 */

@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {

}