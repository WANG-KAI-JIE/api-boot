package top.kjwang.rbac.service;

import top.kjwang.rbac.vo.SysCaptchaVO;

/**
 * @author kjwang
 * @date 2023/4/23 23:54
 * @description SysCaptchaService 验证码接口
 */

public interface SysCaptchaService {
    /**
     * 生成验证码
     */
    SysCaptchaVO generate();

    /**
     * 验证码效验
     *
     * @param key  key
     * @param code 验证码
     * @return true：成功  false：失败
     */
    boolean validate(String key, String code);
}

