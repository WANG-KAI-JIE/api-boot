package top.kjwang.rbac.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Objects;

/**
 * @author kjwang
 * @date 2023/4/23 22:29
 * @description SuperAdminEnum 超级管理员枚举
 */

@Getter
@AllArgsConstructor
public enum SuperAdminEnum {
    /**
     * 是
     */
    YES(1, "是"),
    /**
     * 否
     */
    NO(0, "否");

    private final Integer value;
    private final String name;

    public static String getNameByValue(int value) {
        for (SuperAdminEnum s : SuperAdminEnum.values()) {
            if (s.getValue() == value) {
                return s.getName();
            }
        }
        return "";
    }

    public static Integer getValueByName(String name) {
        for (SuperAdminEnum s : SuperAdminEnum.values()) {
            if (Objects.equals(s.getName(), name)) {
                return s.getValue();
            }
        }
        return null;
    }
}