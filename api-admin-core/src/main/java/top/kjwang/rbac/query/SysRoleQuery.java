package top.kjwang.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kjwang.common.query.Query;

/**
 * @author kjwang
 * @date 2023/5/2 09:22
 * @description SysRoleQuery 角色查询参数
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色查询")
public class SysRoleQuery extends Query {
	@Schema(description = "角色名称")
	private String name;

}