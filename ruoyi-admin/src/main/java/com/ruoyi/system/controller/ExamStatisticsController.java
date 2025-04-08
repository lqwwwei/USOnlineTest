package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.ExamStatistics;
import com.ruoyi.system.service.IExamStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/examStatistics")
public class ExamStatisticsController extends BaseController {

    @Autowired
    private IExamStatisticsService examStatisticsService;

    @GetMapping("/{examId}")
    public AjaxResult getStatistics(@PathVariable Long examId) {
        ExamStatistics statistics = examStatisticsService.getExamStatistics(examId);
        return success(statistics);
    }
}