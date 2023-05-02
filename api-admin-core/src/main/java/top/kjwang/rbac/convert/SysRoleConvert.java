package top.kjwang.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.kjwang.rbac.entity.SysRoleEntity;
import top.kjwang.rbac.vo.SysRoleVO;

import java.util.List;

/**
 * @author kjwang
 * @date 2023/5/2 09:25
 * @description SysRoleConvert 系统角色实体转换
 */

@Mapper
public interface SysRoleConvert {
	SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

	SysRoleVO convert(SysRoleEntity entity);

	SysRoleEntity convert(SysRoleVO vo);

	List<SysRoleVO> convertList(List<SysRoleEntity> list);

}
