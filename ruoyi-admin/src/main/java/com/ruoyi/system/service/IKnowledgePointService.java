package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.KnowledgePoint;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-03-17
 */
public interface IKnowledgePointService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public KnowledgePoint selectKnowledgePointById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param knowledgePoint 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<KnowledgePoint> selectKnowledgePointList(KnowledgePoint knowledgePoint);

    /**
     * 新增【请填写功能名称】
     * 
     * @param knowledgePoint 【请填写功能名称】
     * @return 结果
     */
    public int insertKnowledgePoint(KnowledgePoint knowledgePoint);

    /**
     * 修改【请填写功能名称】
     * 
     * @param knowledgePoint 【请填写功能名称】
     * @return 结果
     */
    public int updateKnowledgePoint(KnowledgePoint knowledgePoint);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteKnowledgePointByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteKnowledgePointById(Long id);
}
