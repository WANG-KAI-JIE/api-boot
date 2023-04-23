package top.kjwang.service;


import org.springframework.web.multipart.MultipartFile;
import top.kjwang.common.utils.PageResult;
import top.kjwang.entity.NoticeEntity;
import top.kjwang.mybatis.service.BaseService;
import top.kjwang.query.NoticeQuery;
import top.kjwang.vo.NoticeVO;

import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/24 00:45
 * @description NoticeService 通知模块服务接口
 */


public interface NoticeService extends BaseService<NoticeEntity> {
    /**
     * 分页查询通知
     *
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<NoticeVO> page(NoticeQuery query);

    /**
     * 获取所有通知数据
     *
     * @return list
     */
    List<NoticeVO> getList();

    /**
     * 新增通知
     *
     * @param vo vo
     */
    void save(NoticeVO vo);

    /**
     * 修改通知
     *
     * @param vo vo
     */
    void update(NoticeVO vo);

    /**
     * 根据id删除通知
     *
     * @param id id
     */
    void delete(Long id);

}
