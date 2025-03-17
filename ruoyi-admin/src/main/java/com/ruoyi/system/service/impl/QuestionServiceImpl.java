package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.QuestionMapper;
import com.ruoyi.system.domain.Question;
import com.ruoyi.system.service.IQuestionService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-17
 */
@Service
public class QuestionServiceImpl implements IQuestionService 
{
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Question selectQuestionById(Long id)
    {
        return questionMapper.selectQuestionById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param question 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Question> selectQuestionList(Question question)
    {
        return questionMapper.selectQuestionList(question);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param question 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQuestion(Question question)
    {
        return questionMapper.insertQuestion(question);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param question 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQuestion(Question question)
    {
        return questionMapper.updateQuestion(question);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteQuestionByIds(Long[] ids)
    {
        return questionMapper.deleteQuestionByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteQuestionById(Long id)
    {
        return questionMapper.deleteQuestionById(id);
    }
}
