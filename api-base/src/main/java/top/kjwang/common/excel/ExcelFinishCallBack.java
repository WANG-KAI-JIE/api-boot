package top.kjwang.common.excel;

import java.util.List;

/**
 * @author kjwang
 * @date 2023/4/23 21:52
 * @description ExcelFinishCallBack excel读取数据完成
 */

public interface ExcelFinishCallBack<T> {

    /**
     * 导出后置处理数据
     *
     * @param result result
     */
    void doAfterAllAnalysed(List<T> result);

    /**
     * @param result result
     */
    default void doSaveBatch(List<T> result) {
    }
}