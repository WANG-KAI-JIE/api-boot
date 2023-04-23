package top.kjwang.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.kjwang.rbac.entity.SysUserEntity;
import top.kjwang.rbac.vo.SysUserVO;
import top.kjwang.security.user.UserDetail;

import java.util.List;


/**
 * @author kjwang
 * @date 2023/4/23 23:25
 * @description SysUserConvert 用户实体转换
 */

@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserEntity convert(SysUserVO vo);

    UserDetail convertDetail(SysUserEntity entity);

    SysUserVO convert(UserDetail detail);


    List<SysUserVO> converList(List<SysUserEntity> list);

}