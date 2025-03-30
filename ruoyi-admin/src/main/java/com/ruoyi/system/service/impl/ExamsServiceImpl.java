package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.service.IExamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ExamsMapper;
import com.ruoyi.system.domain.Exams;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-26
 */
@Service
public class ExamsServiceImpl implements IExamsService
{
    @Autowired
    private ExamsMapper examsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param examId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Exams selectExamsByExamId(Long examId)
    {
        return examsMapper.selectExamsByExamId(examId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param exams 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Exams> selectExamsList(Exams exams)
    {
        return examsMapper.selectExamsList(exams);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param exams 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertExams(Exams exams)
    {
        exams.setCreateTime(DateUtils.getNowDate());
        return examsMapper.insertExams(exams);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param exams 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateExams(Exams exams)
    {
        return examsMapper.updateExams(exams);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param examIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteExamsByExamIds(Long[] examIds)
    {
        return examsMapper.deleteExamsByExamIds(examIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param examId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteExamsByExamId(Long examId)
    {
        return examsMapper.deleteExamsByExamId(examId);
    }
}
