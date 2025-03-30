package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.UserWithRoles;
import com.ruoyi.system.service.IExamsService;
import com.ruoyi.system.service.UserService;
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
import com.ruoyi.system.domain.Exams;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2025-03-26
 */
@RestController
@RequestMapping("/system/exams")
public class ExamsController extends BaseController
{
    @Autowired
    private IExamsService examsService;
    @Autowired
    private UserService userService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:exams:list')")
    @GetMapping("/list")
    public TableDataInfo list(Exams exams)
    {
        startPage();
        List<Exams> list = examsService.selectExamsList(exams);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:exams:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Exams exams)
    {
        List<Exams> list = examsService.selectExamsList(exams);
        ExcelUtil<Exams> util = new ExcelUtil<Exams>(Exams.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:exams:query')")
    @GetMapping(value = "/{examId}")
    public AjaxResult getInfo(@PathVariable("examId") Long examId)
    {
        return success(examsService.selectExamsByExamId(examId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:exams:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Exams exams)
    {
        return toAjax(examsService.insertExams(exams));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:exams:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Exams exams)
    {
        return toAjax(examsService.updateExams(exams));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:exams:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{examIds}")
    public AjaxResult remove(@PathVariable Long[] examIds)
    {
        return toAjax(examsService.deleteExamsByExamIds(examIds));
    }

    @GetMapping("/UserlistWithRoles")
    public AjaxResult getUsersWithRoles() {
        List<UserWithRoles> users = userService.getUsersWithRoles();
        return AjaxResult.success(users);
    }

}
