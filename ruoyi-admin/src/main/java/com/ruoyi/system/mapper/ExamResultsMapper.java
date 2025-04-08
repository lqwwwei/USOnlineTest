package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ExamResults;
import com.ruoyi.system.domain.ExamStatistics;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
public interface ExamResultsMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ExamResults selectExamResultsById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param examResults 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ExamResults> selectExamResultsList(ExamResults examResults);

    /**
     * 新增【请填写功能名称】
     * 
     * @param examResults 【请填写功能名称】
     * @return 结果
     */
    public int insertExamResults(ExamResults examResults);

    /**
     * 修改【请填写功能名称】
     * 
     * @param examResults 【请填写功能名称】
     * @return 结果
     */
    public int updateExamResults(ExamResults examResults);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteExamResultsById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamResultsByIds(Long[] ids);

    ExamStatistics selectExamStatistics(Long examId);


    List<ExamStatistics.ScoreRangeVo> selectScoreDistribution(Long examId);
}
