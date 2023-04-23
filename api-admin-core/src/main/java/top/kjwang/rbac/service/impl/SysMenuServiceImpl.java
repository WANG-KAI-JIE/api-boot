package top.kjwang.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.kjwang.mybatis.service.impl.BaseServiceImpl;
import top.kjwang.rbac.dao.SysMenuDao;
import top.kjwang.rbac.entity.SysMenuEntity;
import top.kjwang.rbac.service.SysMenuService;

/**
 * @author kjwang
 * @date 2023/4/23 23:04
 * @description SysMenuServiceImpl 系统菜单业务实现类
 */

@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

}