package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.mapper.ExamScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ExamResultsMapper;
import com.ruoyi.system.domain.ExamResults;
import com.ruoyi.system.service.IExamResultsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@Service
public class ExamResultsServiceImpl implements IExamResultsService 
{
    @Autowired
    private ExamResultsMapper examResultsMapper;

    @Autowired
    private ExamScoreMapper examScoreMapper;
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ExamResults selectExamResultsById(Long id)
    {
        return examResultsMapper.selectExamResultsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param examResults 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ExamResults> selectExamResultsList(ExamResults examResults)
    {
        return examResultsMapper.selectExamResultsList(examResults);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param examResults 【请填写功能名称】
     * @return 结果
     */
//    @Override
//    public int insertExamResults(ExamResults examResults)
//    {
//        examResults.setCreateTime(DateUtils.getNowDate());
//        return examResultsMapper.insertExamResults(examResults);
//    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param examResults 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateExamResults(ExamResults examResults)
    {
        return examResultsMapper.updateExamResults(examResults);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteExamResultsByIds(Long[] ids)
    {
        return examResultsMapper.deleteExamResultsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteExamResultsById(Long id)
    {
        return examResultsMapper.deleteExamResultsById(id);
    }

    @Override
    public int insertExamResults(ExamResults examResults) {
        // 计算总得分
        BigDecimal totalScore = examScoreMapper.calculateTotalScoreByExamAndUser(
                examResults.getExamId(),
                examResults.getUserId()
        );
        examResults.setTotalScore(totalScore);

        return examResultsMapper.insertExamResults(examResults);
}
}
