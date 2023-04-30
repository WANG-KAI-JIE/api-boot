package top.kjwang.rbac.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import top.kjwang.common.excel.DateConverter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author kjwang
 * @date 2023/4/28 13:59
 * @description SysUserExcelVO
 */

@Data
public class SysUserExcelVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    private long id;

    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("真实姓名")
    private String realName;

    @ExcelProperty("性别")
    private Integer gender;

    @ExcelProperty("邮箱")
    private String email;

    @ExcelProperty("状态")
    private Integer status;

    @ExcelProperty(value = "创建时间",converter = DateConverter.class)
    private Date createTime;
}
