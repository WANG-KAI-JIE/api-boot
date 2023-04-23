package top.kjwang.rbac.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.kjwang.mybatis.service.impl.BaseServiceImpl;
import top.kjwang.rbac.dao.SysUserDao;
import top.kjwang.rbac.entity.SysUserEntity;
import top.kjwang.rbac.service.SysUserService;

/**
 * @author kjwang
 * @date 2023/4/23 22:58
 * @description SysUserServiceImpl 系统用户业务实现类
 */

@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

}
