package com.ruoyi.system.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.system.domain.ExamScore;
import org.apache.ibatis.annotations.Param;

/**
 * 考试得分记录Mapper接口
 * 
 * @author ruoyi
 * @date 2025-03-28
 */
public interface ExamScoreMapper 
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
     * 删除考试得分记录
     * 
     * @param id 考试得分记录主键
     * @return 结果
     */
    public int deleteExamScoreById(Long id);

    /**
     * 批量删除考试得分记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteExamScoreByIds(Long[] ids);

    ExamScore selectByUserAndQuestion(@Param("examId") Long examId,
                                      @Param("userId") Long userId,
                                      @Param("questionId") Long questionId);

    public BigDecimal calculateTotalScoreByExamAndUser(@Param("examId") Long examId,
                                                       @Param("userId") Long userId);
}
