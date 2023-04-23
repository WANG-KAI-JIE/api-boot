package top.kjwang.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kjwang.mybatis.entity.BaseEntity;

/**
 * @author kjwang
 * @date 2023/4/23 22:34
 * @description SysRoleMenuEntity 角色菜单关系表实体类
 */

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_role_menu")
public class SysRoleMenuEntity extends BaseEntity {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;

}