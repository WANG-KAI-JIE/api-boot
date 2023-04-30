package top.kjwang.rbac.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.kjwang.rbac.entity.SysUserEntity;
import top.kjwang.rbac.vo.SysUserExcelVO;
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

    SysUserVO convert(SysUserEntity entity);
    SysUserEntity convert(SysUserVO vo);
    SysUserVO convert(UserDetail userDetail);
    UserDetail convertDetail(SysUserEntity entity);
    List<SysUserVO> convertList(List<SysUserEntity> list);
    List<SysUserExcelVO> convert2List(List<SysUserEntity> list);
    List<SysUserEntity> convertListEntity(List<SysUserExcelVO> list);
}