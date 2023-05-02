package top.kjwang.rbac.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.kjwang.common.utils.DateUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author kjwang
 * @date 2023/5/2 09:21
 * @description SysRoleVO 角色管理
 */

@Data
@Schema(description = "角色vo")
public class SysRoleVO implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Schema(description = "id")
	private Long id;

	@Schema(description = "角色名称")
	@NotBlank(message = "角色名称不能为空")
	private String name;

	@Schema(description = "备注")
	private String remark;


	@Schema(description = "菜单ID列表")
	private List<Long> menuIdList;


	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTime;

}