package top.kjwang.rbac.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kjwang.common.utils.PageResult;
import top.kjwang.common.utils.Result;
import top.kjwang.rbac.query.SysLogLoginQuery;
import top.kjwang.rbac.service.SysLogLoginService;
import top.kjwang.rbac.vo.SysLogLoginVO;

/**
 * @author kjwang
 * @date 2023/4/24 00:31
 * @description SysLogLoginController 登录日志接口
 */

@RestController
@RequestMapping("sys/log/login")
@Tag(name = "登录日志")
@AllArgsConstructor
public class SysLogLoginController {
    private final SysLogLoginService sysLogLoginService;

    @GetMapping("page")
    @Operation(summary = "登录日志分页")
    //授权
    public Result<PageResult<SysLogLoginVO>> page(@ParameterObject @Valid SysLogLoginQuery query) {
        PageResult<SysLogLoginVO> page = sysLogLoginService.page(query);
        return Result.ok(page);
    }
}