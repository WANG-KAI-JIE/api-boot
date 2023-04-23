package top.kjwang.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import top.kjwang.common.utils.AddressUtils;
import top.kjwang.common.utils.HttpContextUtils;
import top.kjwang.common.utils.IpUtils;
import top.kjwang.common.utils.PageResult;
import top.kjwang.mybatis.service.impl.BaseServiceImpl;
import top.kjwang.rbac.convert.SysLogLoginConvert;
import top.kjwang.rbac.dao.SysLogLoginDao;
import top.kjwang.rbac.entity.SysLogLoginEntity;
import top.kjwang.rbac.query.SysLogLoginQuery;
import top.kjwang.rbac.service.SysLogLoginService;
import top.kjwang.rbac.vo.SysLogLoginVO;
import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/23 23:08
 * @description SysLogLoginServiceImpl 登录日志业务实现类
 */

@Service
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService {

    @Override
    public PageResult<SysLogLoginVO> page(SysLogLoginQuery query) {
        IPage<SysLogLoginEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        List<SysLogLoginEntity> list = page.getRecords();
        List<SysLogLoginVO> resList = SysLogLoginConvert.INSTANCE.converList(list);
        long count = page.getTotal();
        return new PageResult<>(resList, count);
    }

    private LambdaQueryWrapper<SysLogLoginEntity> getWrapper(SysLogLoginQuery query) {
        LambdaQueryWrapper<SysLogLoginEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StrUtil.isNotBlank(query.getUsername()), SysLogLoginEntity::getUsername, query.getUsername());
        wrapper.like(StrUtil.isNotBlank(query.getAddress()), SysLogLoginEntity::getAddress, query.getAddress());
        wrapper.like(query.getStatus() != null, SysLogLoginEntity::getStatus, query.getStatus());
        wrapper.orderByDesc(SysLogLoginEntity::getId);
        return wrapper;
    }

    @Override
    public void save(String username, Integer status, Integer operation) {
        // 获得请求对象
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 从请求对象中获取请求地址、IP、UA 等信息
        assert request != null;
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);  // 要加 org.springframework.http.HttpHeaders
        String ip = IpUtils.getIpAddr(request);
        String address = AddressUtils.getAddressByIP(ip);

        SysLogLoginEntity entity = new SysLogLoginEntity();
        entity.setUsername(username);
        entity.setIp(ip);
        entity.setAddress(address);
        entity.setUserAgent(userAgent);
        entity.setStatus(status);
        entity.setOperation(operation);
        baseMapper.insert(entity);
    }
}