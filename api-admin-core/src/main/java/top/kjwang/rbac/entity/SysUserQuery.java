package top.kjwang.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kjwang.common.query.Query;
import top.kjwang.rbac.enums.UserStatusEnum;

/**
 * @author kjwang
 * @date 2023/4/28 14:52
 * @description SysUserQuery
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUserQuery extends Query {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别   0：男   1：女   2：未知
     */
    private Integer gender;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 超级管理员   0：否   1：是
     */
    private Integer superAdmin;
    /**
     * 状态  {@link UserStatusEnum}
     */
    private Integer status;
}
