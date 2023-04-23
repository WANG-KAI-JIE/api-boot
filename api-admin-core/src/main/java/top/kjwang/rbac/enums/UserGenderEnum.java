package top.kjwang.rbac.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Objects;

/**
 * @author kjwang
 * @date 2023/4/23 22:29
 * @description UserGenderEnum 用户性别枚举
 */

@Getter
@AllArgsConstructor
public enum UserGenderEnum {
    /**
     * 男
     */
    MAN(0, "男"),
    /**
     * 女
     */
    WOMEN(1, "女"),
    /**
     * 未知
     */
    UNKNOWN(2,"未知");

    private final int value;
    private final String name;

    public static String getNameByValue(int value) {
        for (UserGenderEnum s : UserGenderEnum.values()) {
            if (s.getValue() == value) {
                return s.getName();
            }
        }
        return "";
    }

    public static Integer getValueByName(String name) {
        for (UserGenderEnum s : UserGenderEnum.values()) {
            if (Objects.equals(s.getName(), name)) {
                return s.getValue();
            }
        }
        return null;
    }
}
