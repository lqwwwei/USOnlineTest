package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ExamScore;

/**
 * 考试得分记录Service接口
 * 
 * @author ruoyi
 * @date 2025-03-28
 */
public interface IExamScoreService 
{
    /**
     * 查询考试得分记录
     * 
     * @param id 考试得分记录主键
     * @return 考试得分记录
     */
    public ExamScore selectExamScoreById(Long id);

    /**
     * 查询考试得分记录列表
     * 
     * @param examScore 考试得分记录
     * @return 考试得分记录集合
     */
    public List<ExamScore> selectExamScoreList(ExamScore examScore);

    /**
     * 新增考试得分记录
     * 
     * @param examScore 考试得分记录
     * @return 结果
     */
    public int insertExamScore(ExamScore examScore);

    /**
     * 修改考试得分记录
     * 
     * @param examScore 考试得分记录
     * @return 结果
     */
    public int updateExamScore(ExamScore examScore);

    /**
     * 批量删除考试得分记录
     * 
     * @param ids 需要删除的考试得分记录主键集合
     * @return 结果
     */
    public int deleteExamScoreByIds(Long[] ids);

    /**
     * 删除考试得分记录信息
     * 
     * @param id 考试得分记录主键
     * @return 结果
     */
    public int deleteExamScoreById(Long id);

    int saveOrUpdateExamScore(ExamScore examScore);


}
