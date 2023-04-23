package top.kjwang.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kjwang.mybatis.entity.BaseEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:33
 * @description SysUserRoleEntity 用户角色关系表实体类
 */

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_user_role")
public class SysUserRoleEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 用户ID
     */
    private Long userId;

}
