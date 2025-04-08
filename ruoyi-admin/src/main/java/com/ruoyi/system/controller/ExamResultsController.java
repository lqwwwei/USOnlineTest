package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Exams;
import com.ruoyi.system.service.IExamsService;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.system.domain.ExamResults;
import com.ruoyi.system.service.IExamResultsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2025-04-01
 */
@RestController
@RequestMapping("/system/results")
public class ExamResultsController extends BaseController
{
    @Autowired
    private IExamResultsService examResultsService;

    @Autowired
    private IExamsService examsService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:results:list')")
    @GetMapping("/list")
    public TableDataInfo list(ExamResults examResults)
    {
        startPage();
        List<ExamResults> list = examResultsService.selectExamResultsList(examResults);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:results:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ExamResults examResults)
    {
        List<ExamResults> list = examResultsService.selectExamResultsList(examResults);
        ExcelUtil<ExamResults> util = new ExcelUtil<ExamResults>(ExamResults.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:results:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(examResultsService.selectExamResultsById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
//    @PreAuthorize("@ss.hasPermi('system:results:add')")
    @Log(title = "考试成绩", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ExamResults examResults) {
        // 参数校验
        if (examResults.getExamId() == null || examResults.getUserId() == null) {
            return AjaxResult.error("参数不能为空");
        }

        // 1. 获取考试信息
        Exams exam = examsService.selectExamsByExamId(examResults.getExamId());
        if (exam == null) {
            return AjaxResult.error("考试不存在");
        }

        // 2. 处理实考人员数组
        String attendeeIds = exam.getAttendeeIds();
        List<Long> attendees = new ArrayList<>();

        // 解析现有参加人员
        if (StringUtils.isNotEmpty(attendeeIds)) {
            try {
                attendees = new ObjectMapper().readValue(attendeeIds, new TypeReference<List<Long>>() {});
            } catch (JsonProcessingException e) {
                return AjaxResult.error("考试数据格式错误");
            }
        }

        // 添加新参加人员（去重）
        Long userId = examResults.getUserId();
        if (!attendees.contains(userId)) {
            attendees.add(userId);
        }

        // 3. 更新考试信息
        try {
            exam.setAttendeeIds(new ObjectMapper().writeValueAsString(attendees));
            examsService.updateExams(exam);
        } catch (JsonProcessingException e) {

            return AjaxResult.error("数据处理失败");
        }

        // 4. 设置用户名并添加成绩记录
        SysUser user = userService.selectUserById(userId);
        if (user != null) {
            examResults.setUserName(user.getUserName());
        }

        return toAjax(examResultsService.insertExamResults(examResults));
    }
    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:results:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ExamResults examResults)
    {
        return toAjax(examResultsService.updateExamResults(examResults));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:results:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(examResultsService.deleteExamResultsByIds(ids));
    }
}
