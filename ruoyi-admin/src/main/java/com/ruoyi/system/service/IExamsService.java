package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Exams;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-03-26
 */
public interface IExamsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param examId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Exams selectExamsByExamId(Long examId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param exams 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Exams> selectExamsList(Exams exams);

    /**
     * 新增【请填写功能名称】
     * 
     * @param exams 【请填写功能名称】
     * @return 结果
     */
    public int insertExams(Exams exams);

    /**
     * 修改【请填写功能名称】
     * 
     * @param exams 【请填写功能名称】
     * @return 结果
     */
    public int updateExams(Exams exams);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param examIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteExamsByExamIds(Long[] examIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param examId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteExamsByExamId(Long examId);
}
