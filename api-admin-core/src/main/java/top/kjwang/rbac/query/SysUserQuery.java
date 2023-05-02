package top.kjwang.rbac.query;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kjwang.common.query.Query;
import top.kjwang.rbac.enums.UserStatusEnum;

import java.util.Date;

/**
 * @author kjwang
 * @date 2023/4/28 14:52
 * @description SysUserQuery
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "用户查询参数")
public class SysUserQuery extends Query {
    @Schema(description = "用户名")
    private String username;

    @Schema(description = "真实姓名")
    private String realName;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "性别")
    private Integer gender;

    @Schema(description = "创建起始时间")
    private Date beginTime;

    @Schema(description = "创建结束时间")
    private Date endTime;
}
