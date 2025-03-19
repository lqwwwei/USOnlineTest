package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.QuestiontypeMapper;
import com.ruoyi.system.domain.Questiontype;
import com.ruoyi.system.service.IQuestiontypeService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-19
 */
@Service
public class QuestiontypeServiceImpl implements IQuestiontypeService 
{
    @Autowired
    private QuestiontypeMapper questiontypeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Questiontype selectQuestiontypeById(Long id)
    {
        return questiontypeMapper.selectQuestiontypeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param questiontype 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Questiontype> selectQuestiontypeList(Questiontype questiontype)
    {
        return questiontypeMapper.selectQuestiontypeList(questiontype);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param questiontype 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQuestiontype(Questiontype questiontype)
    {
        return questiontypeMapper.insertQuestiontype(questiontype);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param questiontype 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQuestiontype(Questiontype questiontype)
    {
        return questiontypeMapper.updateQuestiontype(questiontype);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteQuestiontypeByIds(Long[] ids)
    {
        return questiontypeMapper.deleteQuestiontypeByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteQuestiontypeById(Long id)
    {
        return questiontypeMapper.deleteQuestiontypeById(id);
    }
}
