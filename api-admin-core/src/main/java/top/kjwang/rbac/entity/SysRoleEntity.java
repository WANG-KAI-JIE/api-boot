package top.kjwang.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kjwang.mybatis.entity.BaseEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:32
 * @description SysRoleEntity 角色表实体类
 */

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
}

