package top.kjwang.security.cache;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import top.kjwang.common.cache.RedisCache;
import top.kjwang.common.cache.RedisKeys;
import top.kjwang.security.user.UserDetail;

/**
 * @author kjwang
 * @date 2023/4/23 22:07
 * @description TokenStoreCache 登录用户的缓存操作
 */

@Component
@AllArgsConstructor
public class TokenStoreCache {

    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}

