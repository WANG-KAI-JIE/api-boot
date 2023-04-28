package top.kjwang.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import top.kjwang.common.utils.PageResult;
import top.kjwang.common.utils.Result;
import top.kjwang.convert.NoticeConvert;
import top.kjwang.entity.NoticeEntity;
import top.kjwang.query.NoticeQuery;
import top.kjwang.service.NoticeService;
import top.kjwang.vo.NoticeVO;

import java.util.List;


/**
 * @author kjwang
 * @date 2023/4/24 00:48
 * @description NoticeController 通知模块接口
 */

@RestController
@RequestMapping("/sys/notice")
@Tag(name = "通知管理")
@AllArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;


    @GetMapping("page")
    @Operation(summary = "通知分页")
    @PreAuthorize("hasAuthority('sys:notice:page')")
    public Result<PageResult<NoticeVO>> page(@ParameterObject @Valid NoticeQuery query) {
        PageResult<NoticeVO> page = noticeService.page(query);
        return Result.ok(page);
    }

    @GetMapping("list")
    @Operation(summary = "通知列表")
    public Result<List<NoticeVO>> list() {
        List<NoticeVO> list = noticeService.getList();
        return Result.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "通知信息")
    @PreAuthorize("hasAuthority('sys:notice:info')")
    public Result<NoticeVO> get(@PathVariable("id") Long id) {
        NoticeEntity entity = noticeService.getById(id);
        return Result.ok(NoticeConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "新增通知")
    @PreAuthorize("hasAuthority('sys:notice:save')")
    public Result<String> save(@RequestBody NoticeVO vo) {
        noticeService.save(vo);
        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改通知")
    @PreAuthorize("hasAuthority('sys:notice:update')")
    public Result<String> update(@RequestBody @Valid NoticeVO vo) {
        noticeService.update(vo);
        return Result.ok();
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除通知")
    @PreAuthorize("hasAuthority('sys:notice:delete')")
    public Result<String> delete(@PathVariable Long id) {
        noticeService.delete(id);
        return Result.ok();
    }

    @PostMapping("delete")
    @Operation(summary = "批量删除通知")
    @PreAuthorize("hasAuthority('sys:notice:delete')")
    public Result<String> delete(@RequestBody List<Long> ids){
        noticeService.delete(ids);
        return Result.ok("删除成功");
    }

}