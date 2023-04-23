package top.kjwang.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kjwang.mybatis.entity.BaseEntity;

/**
 * @author kjwang
 * @date 2023/4/24 00:38
 * @description NoticeEntity otice 实体类
 */

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_notice")
public class NoticeEntity extends BaseEntity {
    /**
     * 通知标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String content;
}
