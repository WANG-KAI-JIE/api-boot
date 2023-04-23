package top.kjwang.rbac.service.impl;

import org.springframework.stereotype.Service;
import top.kjwang.mybatis.service.impl.BaseServiceImpl;
import top.kjwang.rbac.dao.SysLogLoginDao;
import top.kjwang.rbac.entity.SysLogLoginEntity;
import top.kjwang.rbac.service.SysLogLoginService;

/**
 * @author kjwang
 * @date 2023/4/23 23:08
 * @description SysLogLoginServiceImpl 登录日志业务实现类
 */

@Service
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService {

}
