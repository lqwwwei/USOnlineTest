package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.KnowledgePointMapper;
import com.ruoyi.system.domain.KnowledgePoint;
import com.ruoyi.system.service.IKnowledgePointService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-17
 */
@Service
public class KnowledgePointServiceImpl implements IKnowledgePointService 
{
    @Autowired
    private KnowledgePointMapper knowledgePointMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public KnowledgePoint selectKnowledgePointById(Long id)
    {
        return knowledgePointMapper.selectKnowledgePointById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param knowledgePoint 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<KnowledgePoint> selectKnowledgePointList(KnowledgePoint knowledgePoint)
    {
        return knowledgePointMapper.selectKnowledgePointList(knowledgePoint);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param knowledgePoint 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertKnowledgePoint(KnowledgePoint knowledgePoint)
    {
        return knowledgePointMapper.insertKnowledgePoint(knowledgePoint);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param knowledgePoint 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateKnowledgePoint(KnowledgePoint knowledgePoint)
    {
        return knowledgePointMapper.updateKnowledgePoint(knowledgePoint);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgePointByIds(Long[] ids)
    {
        return knowledgePointMapper.deleteKnowledgePointByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgePointById(Long id)
    {
        return knowledgePointMapper.deleteKnowledgePointById(id);
    }
}
