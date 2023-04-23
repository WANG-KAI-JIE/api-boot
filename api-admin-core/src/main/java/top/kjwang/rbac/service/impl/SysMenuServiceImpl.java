package top.kjwang.rbac.service.impl;


import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.kjwang.common.constant.Constant;
import top.kjwang.common.utils.TreeUtils;
import top.kjwang.mybatis.service.impl.BaseServiceImpl;
import top.kjwang.rbac.convert.SysMenuConvert;
import top.kjwang.rbac.dao.SysMenuDao;
import top.kjwang.rbac.entity.SysMenuEntity;
import top.kjwang.rbac.enums.SuperAdminEnum;
import top.kjwang.rbac.service.SysMenuService;
import top.kjwang.rbac.vo.SysMenuVO;
import top.kjwang.security.user.UserDetail;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kjwang
 * @date 2023/4/23 23:04
 * @description SysMenuServiceImpl 系统菜单业务实现类
 */

@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Override
    public List<SysMenuVO> getMenuList(Integer type) {
        List<SysMenuEntity> menuList = baseMapper.getMenuList(type);
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList), Constant.ROOT);
    }

    @Override
    public List<SysMenuVO> getUserMenuList(UserDetail user, Integer type) {
        List<SysMenuEntity> menuList;
        // 系统管理员，拥有最高权限
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
            menuList = baseMapper.getMenuList(type);
        } else {
            menuList = baseMapper.getUserMenuList(user.getId(), type);
        }
        return TreeUtils.build(SysMenuConvert.INSTANCE.convertList(menuList));
    }

    @Override
    public Set<String> getUserAuthority(UserDetail user) {
        List<String> authorityList;
        // 系统管理员
        if (user.getSuperAdmin().equals(SuperAdminEnum.YES.getValue())) {
            // 赋予所有权限
            authorityList = baseMapper.getAuthorityList();
        } else {
            // 查询该用户的所有权限
            authorityList = baseMapper.getUserAuthorityList(user.getId());
        }

        // 根据，分割字符串，得到的list，去重去空，加入set
        Set<String> permsSet = new HashSet<>();
        for (String authority : authorityList) {
            if (StrUtil.isBlank(authority)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(authority.trim().split(",")));
        }
        return permsSet;
    }
}