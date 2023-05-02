package top.kjwang.rbac.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.kjwang.common.constant.Constant;
import top.kjwang.common.utils.Result;
import top.kjwang.rbac.convert.SysMenuConvert;
import top.kjwang.rbac.entity.SysMenuEntity;
import top.kjwang.rbac.enums.MenuTypeEnum;
import top.kjwang.rbac.service.SysMenuService;
import top.kjwang.rbac.vo.SysMenuVO;
import top.kjwang.security.user.SecurityUser;
import top.kjwang.security.user.UserDetail;

import java.util.List;
import java.util.Set;

/**
 * @author kjwang
 * @date 2023/5/2 09:45
 * @description SysMenuController 菜单管理
 */



@RestController
@RequestMapping("sys/menu")
@Tag(name = "菜单管理")
@AllArgsConstructor
public class SysMenuController {
	private final SysMenuService sysMenuService;

	@GetMapping("nav")
	@Operation(summary = "菜单导航")
	public Result<List<SysMenuVO>> nav() {
		UserDetail user = SecurityUser.getUser();
		List<SysMenuVO> list = sysMenuService.getUserMenuList(user, MenuTypeEnum.MENU.getValue());
		return Result.ok(list);
	}

	@GetMapping("authority")
	@Operation(summary = "用户权限标识")
	public Result<Set<String>> authority() {
		UserDetail user = SecurityUser.getUser();
		Set<String> set = sysMenuService.getUserAuthority(user);
		return Result.ok(set);
	}

	@GetMapping("list")
	@Operation(summary = "菜单列表")
	@Parameter(name = "type", description = "菜单类型 0：菜单 1：按钮  2：接口  null：全部")
	@PreAuthorize("hasAuthority('sys:menu:list')")
	public Result<List<SysMenuVO>> list(Integer type) {
		List<SysMenuVO> list = sysMenuService.getMenuList(type);
		return Result.ok(list);
	}

	@GetMapping("{id}")
	@Operation(summary = "菜单信息")
	@PreAuthorize("hasAuthority('sys:menu:info')")
	public Result<SysMenuVO> get(@PathVariable("id") Long id) {
		SysMenuEntity entity = sysMenuService.getById(id);
		SysMenuVO vo = SysMenuConvert.INSTANCE.convert(entity);
		// 获取上级菜单名称
		if (!Constant.ROOT.equals(entity.getPid())) {
			SysMenuEntity parentEntity = sysMenuService.getById(entity.getPid());
			vo.setParentName(parentEntity.getName());
		}
		return Result.ok(vo);
	}

	@PostMapping
	@Operation(summary = "保存菜单")
	@PreAuthorize("hasAuthority('sys:menu:save')")
	public Result<String> save(@RequestBody @Valid SysMenuVO vo) {
		sysMenuService.save(vo);
		return Result.ok();
	}

	@PutMapping
	@Operation(summary = "修改菜单")
	@PreAuthorize("hasAuthority('sys:menu:update')")
	public Result<String> update(@RequestBody @Valid SysMenuVO vo) {
		sysMenuService.update(vo);
		return Result.ok();
	}

	@DeleteMapping("{id}")
	@Operation(summary = "删除菜单")
	@PreAuthorize("hasAuthority('sys:menu:delete')")
	public Result<String> delete(@PathVariable("id") Long id) {
		// 判断是否有子菜单或按钮
		Long count = sysMenuService.getSubMenuCount(id);
		if (count > 0) {
			return Result.error("请先删除子菜单");
		}
		sysMenuService.delete(id);
		return Result.ok();
	}
}