package top.kjwang.rbac.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author kjwang
 * @date 2023/4/23 22:47
 * @description SysAccoutLoginVO 账号登录vo
 */

@Data
@Schema(description = "账号登录")
public class SysAccountLoginVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "唯一key")
    private String key;

    @Schema(description = "验证码")
    private String captcha;

}
