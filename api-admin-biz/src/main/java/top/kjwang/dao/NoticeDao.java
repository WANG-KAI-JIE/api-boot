package top.kjwang.dao;

import org.apache.ibatis.annotations.Mapper;
import top.kjwang.entity.NoticeEntity;
import top.kjwang.mybatis.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * @author kjwang
 * @date 2023/4/24 00:43
 * @description NoticeDao
 */

@Mapper
public interface NoticeDao extends BaseDao<NoticeEntity> {
	List<NoticeEntity> getList(Map<String,Object> params);
}