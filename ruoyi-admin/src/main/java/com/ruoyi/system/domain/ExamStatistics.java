package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 考试统计VO
 */
public class ExamStatistics extends BaseEntity {
    private String examName;
    private String organizer;
    private String paperAuthor;
    private String examType;
    private Boolean isCloseBook;
    private Integer totalCandidates;
    private Integer actualCandidates;
    private Double averageScore;
    private Double standardDeviation;
    private Double maxScore;
    private Double fullScore;
    private List<ScoreRangeVo> scoreDistribution;

    public static class ScoreRangeVo {
        private String scoreRange;
        private Integer count;
        private String percentage;

        // Getter和Setter


        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }
        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("scoreRange", getScoreRange())
                    .append("count", getCount())
                    .append("percentage", getPercentage())
                    .toString();
        }

        public String getScoreRange() {
            return scoreRange;
        }

        public void setScoreRange(String scoreRange) {
            this.scoreRange = scoreRange;
        }
    }

    // Getter和Setter
    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    // 其他getter/setter方法...
    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getPaperAuthor() {
        return paperAuthor;
    }

    public void setPaperAuthor(String paperAuthor) {
        this.paperAuthor = paperAuthor;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public Boolean getIsCloseBook() {
        return isCloseBook;
    }

    public void setIsCloseBook(Boolean closeBook) {
        isCloseBook = closeBook;
    }

    public Integer getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(Integer totalCandidates) {
        this.totalCandidates = totalCandidates;
    }

    public Integer getActualCandidates() {
        return actualCandidates;
    }

    public void setActualCandidates(Integer actualCandidates) {
        this.actualCandidates = actualCandidates;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }

    public Double getFullScore() {
        return fullScore;
    }

    public void setFullScore(Double fullScore) {
        this.fullScore = fullScore;
    }

    public List<ScoreRangeVo> getScoreDistribution() {
        return scoreDistribution;
    }

    public void setScoreDistribution(List<ScoreRangeVo> scoreDistribution) {
        this.scoreDistribution = scoreDistribution;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("examName", getExamName())
                .append("organizer", getOrganizer())
                .append("paperAuthor", getPaperAuthor())
                .append("examType", getExamType())
                .append("isCloseBook", getIsCloseBook())
                .append("totalCandidates", getTotalCandidates())
                .append("actualCandidates", getActualCandidates())
                .append("averageScore", getAverageScore())
                .append("standardDeviation", getStandardDeviation())
                .append("maxScore", getMaxScore())
                .append("fullScore", getFullScore())
                .append("scoreDistribution", getScoreDistribution())
                .toString();
    }
}