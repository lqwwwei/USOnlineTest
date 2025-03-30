package com.ruoyi.system.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ExamScore;
import com.ruoyi.system.service.IExamScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 考试得分记录Controller
 * 
 * @author ruoyi
 * @date 2025-03-28
 */
@RestController
@RequestMapping("/system/score")
public class ExamScoreController extends BaseController
{
    @Autowired
    private IExamScoreService examScoreService;

    /**
     * 查询考试得分记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:score:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamScore examScore)
    {
        startPage();
        List<ExamScore> list = examScoreService.selectExamScoreList(examScore);
        return getDataTable(list);
    }

    /**
     * 导出考试得分记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:score:export')")
    @Log(title = "考试得分记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExamScore examScore)
    {
        List<ExamScore> list = examScoreService.selectExamScoreList(examScore);
        ExcelUtil<ExamScore> util = new ExcelUtil<ExamScore>(ExamScore.class);
        util.exportExcel(response, list, "考试得分记录数据");
    }

    /**
     * 获取考试得分记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:score:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(examScoreService.selectExamScoreById(id));
    }

    /**
     * 新增考试得分记录
     */
    @PreAuthorize("@ss.hasPermi('system:score:add')")
    @Log(title = "考试得分记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamScore examScore) {
        return toAjax(examScoreService.saveOrUpdateExamScore(examScore));
    }

    /**
     * 修改考试得分记录
     */
    @PreAuthorize("@ss.hasPermi('system:score:edit')")
    @Log(title = "考试得分记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamScore examScore)
    {
        return toAjax(examScoreService.updateExamScore(examScore));
    }

    /**
     * 删除考试得分记录
     */
    @PreAuthorize("@ss.hasPermi('system:score:remove')")
    @Log(title = "考试得分记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examScoreService.deleteExamScoreByIds(ids));
    }
}
