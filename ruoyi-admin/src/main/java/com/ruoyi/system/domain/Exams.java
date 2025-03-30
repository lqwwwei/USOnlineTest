package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 exams
 * 
 * @author ruoyi
 * @date 2025-03-26
 */
public class Exams extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考试ID */
    private Long examId;

    /** 考试名称 */
    @Excel(name = "考试名称")
    private String examName;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 试卷ID */
    @Excel(name = "试卷ID")
    private Long paperId;

    /** 考试方式 */
    @Excel(name = "考试方式")
    private Long examType;

    /** 考试状态 0-进行中 1-已结束 */
    @Excel(name = "考试状态 0-进行中 1-已结束")
    private Long examStatus;

    /** 应考人员ID数组 */
    @Excel(name = "应考人员ID数组")
    private String candidateIds;

    /** 实考人员ID数组 */
    @Excel(name = "实考人员ID数组")
    private String attendeeIds;

    public void setExamId(Long examId) 
    {
        this.examId = examId;
    }

    public Long getExamId() 
    {
        return examId;
    }

    public void setExamName(String examName) 
    {
        this.examName = examName;
    }

    public String getExamName() 
    {
        return examName;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setPaperId(Long paperId) 
    {
        this.paperId = paperId;
    }

    public Long getPaperId() 
    {
        return paperId;
    }

    public void setExamType(Long examType)
    {
        this.examType = examType;
    }

    public Long getExamType()
    {
        return examType;
    }

    public void setExamStatus(Long examStatus) 
    {
        this.examStatus = examStatus;
    }

    public Long getExamStatus() 
    {
        return examStatus;
    }

    public void setCandidateIds(String candidateIds) 
    {
        this.candidateIds = candidateIds;
    }

    public String getCandidateIds() 
    {
        return candidateIds;
    }

    public void setAttendeeIds(String attendeeIds) 
    {
        this.attendeeIds = attendeeIds;
    }

    public String getAttendeeIds() 
    {
        return attendeeIds;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("examId", getExamId())
            .append("examName", getExamName())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("paperId", getPaperId())
            .append("examType", getExamType())
            .append("examStatus", getExamStatus())
            .append("candidateIds", getCandidateIds())
            .append("attendeeIds", getAttendeeIds())
            .append("createTime", getCreateTime())
            .toString();
    }
}
