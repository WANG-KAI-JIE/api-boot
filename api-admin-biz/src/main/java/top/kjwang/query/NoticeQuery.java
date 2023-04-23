package top.kjwang.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kjwang.common.query.Query;

/**
 * @author kjwang
 * @date 2023/4/24 00:44
 * @description NoticeQuery 通知管理查询参数
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "通知管理查询")
public class NoticeQuery extends Query {

    @Schema(description = "通知标题")
    private String title;

}

