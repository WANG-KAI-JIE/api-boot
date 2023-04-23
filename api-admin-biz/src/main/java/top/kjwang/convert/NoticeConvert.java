package top.kjwang.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.kjwang.entity.NoticeEntity;
import top.kjwang.vo.NoticeVO;

import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/24 00:44
 * @description NoticeConvert Notice 实体转换
 */

@Mapper
public interface NoticeConvert {
    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    NoticeVO convert(NoticeEntity entity);

    NoticeEntity convert(NoticeVO vo);

    List<NoticeVO> convertList(List<NoticeEntity> list);

}
