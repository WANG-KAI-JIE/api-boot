package top.kjwang.common.cache;

/**
 * @author kjwang
 * @date 2023/4/23 21:28
 * @description Redis Key 管理
 */
public class RedisKeys {

    /**
     * 验证码Key
     */
    public static String getCaptchaKey(String key) {
        return "sys:captcha:" + key;
    }

    /**
     * accessToken Key
     */
    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:" + accessToken;
    }

}
