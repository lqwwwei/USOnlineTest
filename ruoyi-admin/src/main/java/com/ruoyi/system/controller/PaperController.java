package com.ruoyi.system.controller;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.system.domain.Question;
import com.ruoyi.system.mapper.QuestionMapper;
import com.ruoyi.system.service.IPaperService;
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
import com.ruoyi.system.domain.Paper;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import java.util.stream.Collectors;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2025-03-19
 */
@RestController
@RequestMapping("/system/paper")
public class PaperController extends BaseController
{
    @Autowired
    private IPaperService paperService;
    @Autowired
    private ObjectMapper objectMapper; // Jackson 的 JSON 解析工具
    @Autowired
    QuestionMapper questionMapper;
    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:paper:list')")
    @GetMapping("/list")
    public TableDataInfo list(Paper paper)
    {
        startPage();
        List<Paper> list = paperService.selectPaperList(paper);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:paper:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Paper paper)
    {
        List<Paper> list = paperService.selectPaperList(paper);
        ExcelUtil<Paper> util = new ExcelUtil<Paper>(Paper.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:paper:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(paperService.selectPaperById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:paper:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Paper paper) throws JsonProcessingException {

        List<Map<String, Object>> rules = objectMapper.readValue(
                paper.getRules(),
                new TypeReference<List<Map<String, Object>>>() {}
        );

        // 2. 随机抽题
        List<Integer> questionIds = generateQuestions(rules);
        // 3. 保存题目 ID 集合
        paper.setQuestionIds(questionIds.stream()
                .map(String::valueOf) // 将每个 Integer 转换为 String
                .collect(Collectors.joining(","))); //
        // 5. 保存试卷
        return toAjax(paperService.insertPaper(paper));
    }

    private List<Integer> generateQuestions(List<Map<String, Object>> rules) {
        List<Integer> questionIds = new ArrayList<>();

        for (Map<String, Object> rule : rules) {
            // 解析规则参数
            Integer questionType = (Integer) rule.get("questionType");
            String knowledgeIdStr = (String) rule.get("knowledgeId");
            Integer questionCount = (Integer) rule.get("questionCount");

            // 拆分知识点 ID
            List<Integer> knowledgeIds = Arrays.stream(knowledgeIdStr.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // 查询符合条件的题目
            List<Question> questions = questionMapper.selectByTypeAndKnowledge(
                    questionType,
                    knowledgeIds
            );

            // 检查题目是否为空
            if (questions.isEmpty()) {
                throw new RuntimeException("没有符合条件的题目");
            }

            // 随机抽取题目
            Collections.shuffle(questions);
            List<Question> selected = questions.subList(0, Math.min(questionCount, questions.size()));
            // 收集题目 ID
            selected.forEach(q -> questionIds.add(q.getId().intValue()));
        }
        return questionIds;
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:paper:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Paper paper)
    {
        return toAjax(paperService.updatePaper(paper));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:paper:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(paperService.deletePaperByIds(ids));
    }



}
