package top.kjwang.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.kjwang.common.utils.PageResult;
import top.kjwang.common.utils.Result;
import top.kjwang.rbac.convert.SysRoleConvert;
import top.kjwang.rbac.entity.SysRoleEntity;
import top.kjwang.rbac.query.SysRoleQuery;
import top.kjwang.rbac.service.*;
import top.kjwang.rbac.vo.SysRoleVO;

import java.util.List;

/**
 * @author kjwang
 * @date 2023/5/2 09:44
 * @description SysRoleController
 */



@RestController
@RequestMapping("sys/role")
@Tag(name = "角色管理")
@AllArgsConstructor
public class SysRoleController {
	private final SysRoleService sysRoleService;
	private final SysRoleMenuService sysRoleMenuService;

	@GetMapping("page")
	@Operation(summary = "角色分页")
	@PreAuthorize("hasAuthority('sys:role:page')")
	public Result<PageResult<SysRoleVO>> page(@ParameterObject @Valid SysRoleQuery query) {
		PageResult<SysRoleVO> page = sysRoleService.page(query);
		return Result.ok(page);
	}

	@GetMapping("{id}")
	@Operation(summary = "角色信息")
	@PreAuthorize("hasAuthority('sys:role:info')")
	public Result<SysRoleVO> get(@PathVariable("id") Long id) {
		SysRoleEntity entity = sysRoleService.getById(id);
		SysRoleVO role = SysRoleConvert.INSTANCE.convert(entity);
		// 查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.getMenuIdList(id);
		role.setMenuIdList(menuIdList);
		return Result.ok(role);
	}

	@PostMapping
	@Operation(summary = "保存角色")
	@PreAuthorize("hasAuthority('sys:role:save')")
	public Result<String> save(@RequestBody @Valid SysRoleVO vo) {
		sysRoleService.save(vo);
		return Result.ok();
	}

	@PutMapping
	@Operation(summary = "修改角色")
	@PreAuthorize("hasAuthority('sys:role:update')")
	public Result<String> update(@RequestBody @Valid SysRoleVO vo) {
		sysRoleService.update(vo);
		return Result.ok();
	}

	@DeleteMapping("{id}")
	@Operation(summary = "删除角色")
	@PreAuthorize("hasAuthority('sys:role:delete')")
	public Result<String> delete(@PathVariable("id") Long id) {
		sysRoleService.delete(id);
		return Result.ok();
	}

	@PostMapping("/menus/{roleId}")
	@Operation(summary = "分配权限给角色")
	@PreAuthorize("hasAuthority('sys:role:update')")
	public Result<String> setRoleMenus(@PathVariable("roleId") Long roleId, @RequestBody List<Long> menuIds) {
		sysRoleService.setRoleMenus(roleId, menuIds);
		return Result.ok();
	}

}