package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 考试得分记录对象 exam_score
 * 
 * @author ruoyi
 * @date 2025-03-28
 */
public class ExamScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 考试ID */
    @Excel(name = "考试ID")
    private Long examId;

    /** 考生ID */
    @Excel(name = "考生ID")
    private Long userId;

    /** 试题ID */
    @Excel(name = "试题ID")
    private Long questionId;

    /** 考生答案 */
    @Excel(name = "考生答案")
    private String userAnswer;

    /** 考生得分 */
    @Excel(name = "考生得分")
    private BigDecimal score;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setExamId(Long examId) 
    {
        this.examId = examId;
    }

    public Long getExamId() 
    {
        return examId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setQuestionId(Long questionId) 
    {
        this.questionId = questionId;
    }

    public Long getQuestionId() 
    {
        return questionId;
    }

    public void setUserAnswer(String userAnswer) 
    {
        this.userAnswer = userAnswer;
    }

    public String getUserAnswer() 
    {
        return userAnswer;
    }

    public void setScore(BigDecimal score) 
    {
        this.score = score;
    }

    public BigDecimal getScore() 
    {
        return score;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("examId", getExamId())
            .append("userId", getUserId())
            .append("questionId", getQuestionId())
            .append("userAnswer", getUserAnswer())
            .append("score", getScore())
            .append("createTime", getCreateTime())
            .toString();
    }
}
