package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.ExamStatistics;
import com.ruoyi.system.mapper.ExamResultsMapper;
import com.ruoyi.system.service.IExamStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamStatisticsServiceImpl implements IExamStatisticsService {
    @Autowired
    private ExamResultsMapper examResultsMapper;

    @Override
    public ExamStatistics getExamStatistics(Long examId) {
        ExamStatistics statistics = examResultsMapper.selectExamStatistics(examId);
        if (statistics != null) {
            statistics.setScoreDistribution(examResultsMapper.selectScoreDistribution(examId));
        }
        return statistics;
    }
}
