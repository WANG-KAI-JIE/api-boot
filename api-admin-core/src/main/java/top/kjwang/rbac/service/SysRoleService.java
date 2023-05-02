package top.kjwang.rbac.service;

import top.kjwang.common.utils.PageResult;
import top.kjwang.mybatis.service.BaseService;
import top.kjwang.rbac.entity.SysRoleEntity;
import top.kjwang.rbac.query.SysRoleQuery;
import top.kjwang.rbac.vo.SysRoleVO;

import java.util.List;
/**
 * @author kjwang
 * @date 2023/4/23 22:58
 * @description SysRoleService 系统角色业务接口
 */



public interface SysRoleService extends BaseService<SysRoleEntity> {
	/**
	 * 角色分页列表
	 *
	 * @param query 查询参数
	 */
	PageResult<SysRoleVO> page(SysRoleQuery query);

	/**
	 * 新增角色
	 *
	 * @param vo 入参
	 */
	void save(SysRoleVO vo);

	/**
	 * 更新角色
	 *
	 * @param vo 入参
	 */
	void update(SysRoleVO vo);

	/**
	 * 删除角色
	 *
	 * @param id 角色id
	 */
	void delete(Long id);

	/**
	 * 给角色授权
	 *
	 * @param roleId  角色id
	 * @param menuIds 菜单id集合
	 */
	void setRoleMenus(Long roleId, List<Long> menuIds);

}
