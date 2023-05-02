package top.kjwang.rbac.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kjwang.common.query.Query;

/**
 * @author kjwang
 * @date 2023/5/2 09:42
 * @description SysMenuQuery 菜单查询参数
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "角色查询")
public class SysMenuQuery extends Query {
	@Schema(description = "菜单类型")
	private Integer type;

}