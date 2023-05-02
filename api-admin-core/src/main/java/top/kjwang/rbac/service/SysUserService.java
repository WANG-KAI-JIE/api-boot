package top.kjwang.rbac.service;

import org.springframework.web.multipart.MultipartFile;
import top.kjwang.common.utils.PageResult;
import top.kjwang.mybatis.service.BaseService;
import top.kjwang.rbac.entity.SysUserEntity;
import top.kjwang.rbac.query.SysUserQuery;
import top.kjwang.rbac.vo.SysUserVO;

import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/23 22:57
 * @description SysUserService 系统用户业务接口
 */

public interface SysUserService extends BaseService<SysUserEntity> {
    /**
     * 修改密码
     *
     * @param id          用户ID
     * @param newPassword 新密码
     */
    void updatePassword(Long id, String newPassword);

    /**
     * 分页查询用户
     *
     * @param query 查询参数
     * @return 分页数据
     */
    PageResult<SysUserVO> page(SysUserQuery query);

    /**
     * 新增用户
     *
     * @param vo 入参
     */
    void save(SysUserVO vo);

    /**
     * 修改用户
     *
     * @param vo 入参
     */
    void update(SysUserVO vo);

    /**
     * 批量删除用户
     *
     * @param ids 入参
     */
    void delete(List<Long> ids);

    /**
     * 从表格批量导入用户
     *
     * @param file  excel 文件
     * @param password  密码
     */
    void importByExcel(MultipartFile file, String password);

    /**
     * 导出用户信息到表格
     */
    void export();

    /**
     * 修改用户状态
     *
     * @param id    用户id
     * @param status    需要修改的状态
     */
    void updateStatus(long id ,int status);
}