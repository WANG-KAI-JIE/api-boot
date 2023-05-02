package top.kjwang.rbac.query;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author kjwang
 * @date 2023/5/2 09:23
 * @description SysRoleUserQuery 用户角色查询参数
 */


@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "分配角色查询")
public class SysRoleUserQuery extends SysUserQuery {
	@Schema(description = "角色ID")
	private Long roleId;

}