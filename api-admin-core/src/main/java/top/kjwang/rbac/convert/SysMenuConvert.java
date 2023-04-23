package top.kjwang.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.kjwang.rbac.entity.SysMenuEntity;
import top.kjwang.rbac.vo.SysMenuVO;
import java.util.List;


/**
 * @author kjwang
 * @date 2023/4/23 23:36
 * @description SysMenuConvert 系统菜单实体转换
 */

@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    SysMenuEntity convert(SysMenuVO vo);

    SysMenuVO convert(SysMenuEntity entity);

    List<SysMenuVO> convertList(List<SysMenuEntity> list);

}
