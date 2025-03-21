package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Paper;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-03-19
 */
public interface IPaperService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Paper selectPaperById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param paper 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Paper> selectPaperList(Paper paper);

    /**
     * 新增【请填写功能名称】
     * 
     * @param paper 【请填写功能名称】
     * @return 结果
     */
    public int insertPaper(Paper paper);

    /**
     * 修改【请填写功能名称】
     * 
     * @param paper 【请填写功能名称】
     * @return 结果
     */
    public int updatePaper(Paper paper);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deletePaperByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePaperById(Long id);
}
