package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 paper
 * 
 * @author ruoyi
 * @date 2025-03-19
 */
public class Paper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 试卷ID */
    private Long id;

    /** 试卷名称 */
    @Excel(name = "试卷名称")
    private String title;

    /** 试卷总分 */
    @Excel(name = "试卷总分")
    private BigDecimal totalScore;

    /** 及格分数 */
    @Excel(name = "及格分数")
    private BigDecimal passScore;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 试题ID集合，逗号分隔 */

    private String rules;

    private String questionIds;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTotalScore(BigDecimal totalScore) 
    {
        this.totalScore = totalScore;
    }

    public BigDecimal getTotalScore() 
    {
        return totalScore;
    }

    public void setPassScore(BigDecimal passScore) 
    {
        this.passScore = passScore;
    }

    public BigDecimal getPassScore() 
    {
        return passScore;
    }

    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(String questionIds) {
        this.questionIds = questionIds;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("totalScore", getTotalScore())
                .append("passScore", getPassScore())
                .append("createdBy", getCreatedBy())
                .append("createdAt", getCreatedAt())
                .append("rules",getRules())
                .append("questionIds",getQuestionIds())
                .toString();
    }
}
