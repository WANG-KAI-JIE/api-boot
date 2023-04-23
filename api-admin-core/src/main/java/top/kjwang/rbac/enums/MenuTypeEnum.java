package top.kjwang.rbac.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kjwang
 * @date 2023/4/23 22:30
 * @description MenuTypeEnum 菜单类型枚举
 */

@Getter
@AllArgsConstructor
public enum MenuTypeEnum {
    /**
     * 菜单
     */
    MENU(0),
    /**
     * 按钮
     */
    BUTTON(1),
    /**
     * 接口
     */
    INTERFACE(2);

    private final int value;

}
