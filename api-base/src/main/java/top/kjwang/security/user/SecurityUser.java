package top.kjwang.security.user;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author kjwang
 * @date 2023/4/23 22:04
 * @description SecurityUser Security 用户
 */

public class SecurityUser {

    /**
     * 获取用户信息
     */
    public static UserDetail getUser() {
        UserDetail user;
        try {
            user = (UserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return new UserDetail();
        }

        return user;
    }

    /**
     * 获取用户ID
     */
    public static Long getUserId() {
        return getUser().getId();
    }

}