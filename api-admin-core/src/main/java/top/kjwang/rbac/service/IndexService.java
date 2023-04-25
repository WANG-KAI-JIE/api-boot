package top.kjwang.rbac.service;

import top.kjwang.rbac.vo.BarVO;
import top.kjwang.rbac.vo.LabelVO;
import top.kjwang.rbac.vo.PanelVO;

import java.util.List;
import java.util.Map;

/**
 * @author kjwang
 * @date 2023/4/25 13:47
 * @description IndexService
 */
public interface IndexService {
    /**
     * 后台首页统计1:项目主要数据统计面板
     *
     * @return List<PanelVO>
     */
    List<PanelVO> statistics1();

    /**
     * 后台首页统计2:根据类型 获取 echarts 柱状图数据
     *
     * @return List<PanelVO>
     */
    BarVO statistics2(String type);

    /**
     * 后台首页统计3:分类统计标签
     *
     * @return Map<String,List,<LabelVO>>
     */
    Map<String,List<LabelVO>> statistics3();

}
