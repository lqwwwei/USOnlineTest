package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PaperMapper;
import com.ruoyi.system.domain.Paper;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-19
 */
@Service
public class PaperServiceImpl implements IPaperService
{
    @Autowired
    private PaperMapper paperMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Paper selectPaperById(Long id)
    {
        return paperMapper.selectPaperById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param paper 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Paper> selectPaperList(Paper paper)
    {
        return paperMapper.selectPaperList(paper);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param paper 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPaper(Paper paper)
    {
        return paperMapper.insertPaper(paper);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param paper 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePaper(Paper paper)
    {
        return paperMapper.updatePaper(paper);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePaperByIds(Long[] ids)
    {
        return paperMapper.deletePaperByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePaperById(Long id)
    {
        return paperMapper.deletePaperById(id);
    }
}
