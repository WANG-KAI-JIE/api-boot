package top.kjwang.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.kjwang.rbac.entity.SysLogLoginEntity;
import top.kjwang.rbac.vo.SysLogLoginVO;
import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/24 00:26
 * @description SysLogLoginConvert 登录日志实体转换
 */

@Mapper
public interface SysLogLoginConvert {
    SysLogLoginConvert INSTANCE = Mappers.getMapper(SysLogLoginConvert.class);

    SysLogLoginEntity convert(SysLogLoginVO vo);

    SysLogLoginVO convert(SysLogLoginEntity entity);

    List<SysLogLoginVO> converList(List<SysLogLoginEntity> list);

}