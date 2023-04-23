package top.kjwang.rbac.service;

import top.kjwang.mybatis.service.BaseService;
import top.kjwang.rbac.entity.SysLogLoginEntity;
import top.kjwang.common.utils.PageResult;
import top.kjwang.rbac.query.SysLogLoginQuery;
import top.kjwang.rbac.vo.SysLogLoginVO;

/**
 * @author kjwang
 * @date 2023/4/23 23:08
 * @description SysLogLoginService 登录日志业务接口
 */

public interface SysLogLoginService extends BaseService<SysLogLoginEntity> {
    /**
     * 按条件分页查询
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<SysLogLoginVO> page(SysLogLoginQuery query);

    /**
     * 保存登录日志
     *
     * @param username  用户名
     * @param status    登录状态
     * @param operation 操作信息
     */
    void save(String username, Integer status, Integer operation);
}
