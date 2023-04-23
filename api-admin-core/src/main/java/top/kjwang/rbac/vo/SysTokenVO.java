package top.kjwang.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author kjwang
 * @date 2023/4/23 22:47
 * @description SysTokenVO 用户Token vo
 */

@Data
@AllArgsConstructor
@Schema(description = "用户登录token")
public class SysTokenVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "accessToken")
    private String accessToken;
}
