package top.kjwang.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.kjwang.common.utils.Result;
import top.kjwang.rbac.service.SysAuthService;
import top.kjwang.rbac.service.SysCaptchaService;
import top.kjwang.rbac.vo.SysAccountLoginVO;
import top.kjwang.rbac.vo.SysCaptchaVO;
import top.kjwang.rbac.vo.SysTokenVO;
import top.kjwang.security.utils.TokenUtils;

/**
 * @author kjwang
 * @date 2023/4/23 23:19
 * @description SysAuthController 认证接口
 */

@RestController
@RequestMapping("sys/auth")
@Tag(name = "认证管理")
@AllArgsConstructor
public class SysAuthController {
    private final SysAuthService sysAuthService;
    private final SysCaptchaService sysCaptchaService;

    @GetMapping("captcha")
    @Operation(summary = "验证码")
    public Result<SysCaptchaVO> captcha(){
        SysCaptchaVO captchaVO = sysCaptchaService.generate();
        return Result.ok(captchaVO);
    }

    @PostMapping("login")
    @Operation(summary = "账号密码登录")
    public Result<SysTokenVO> login(@RequestBody SysAccountLoginVO login) {
        SysTokenVO token = sysAuthService.loginByAccount(login);
        return Result.ok(token);
    }

    @PostMapping("logout")
    @Operation(summary = "退出")
    public Result<String> logout(HttpServletRequest request) {
        sysAuthService.logout(TokenUtils.getAccessToken(request));
        return Result.ok();
    }
}
