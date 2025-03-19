package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Questiontype;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2025-03-19
 */
public interface QuestiontypeMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Questiontype selectQuestiontypeById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param questiontype 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Questiontype> selectQuestiontypeList(Questiontype questiontype);

    /**
     * 新增【请填写功能名称】
     * 
     * @param questiontype 【请填写功能名称】
     * @return 结果
     */
    public int insertQuestiontype(Questiontype questiontype);

    /**
     * 修改【请填写功能名称】
     * 
     * @param questiontype 【请填写功能名称】
     * @return 结果
     */
    public int updateQuestiontype(Questiontype questiontype);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteQuestiontypeById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQuestiontypeByIds(Long[] ids);
}
