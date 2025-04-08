package com.ruoyi.system.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.QuestionMapper;
import com.ruoyi.system.domain.Question;
import com.ruoyi.system.service.IQuestionService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-17
 */
@Service
public class QuestionServiceImpl implements IQuestionService 
{
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Question selectQuestionById(Long id)
    {
        return questionMapper.selectQuestionById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param question 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Question> selectQuestionList(Question question)
    {
        return questionMapper.selectQuestionList(question);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param question 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertQuestion(Question question)
    {
        return questionMapper.insertQuestion(question);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param question 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateQuestion(Question question)
    {
        return questionMapper.updateQuestion(question);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteQuestionByIds(Long[] ids)
    {
        return questionMapper.deleteQuestionByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteQuestionById(Long id)
    {
        return questionMapper.deleteQuestionById(id);
    }



    @Override
    public void importQuestions(MultipartFile file, Long knowledgeId,Long type) {
        try {

            // 1. 使用 ExcelUtil 解析 Excel 文件
            ExcelUtil<Question> util = new ExcelUtil<>(Question.class);
            List<Question> questionList = util.importExcel(file.getInputStream());
            // 2. 检查每行的列数
            for (Question question : questionList) {
                if (question.getContent() == null || question.getOptionA() == null ||
                        question.getOptionB() == null || question.getOptionC() == null ||
                        question.getOptionD() == null || question.getCorrectAnswer() == null ) {
                    throw new RuntimeException("Excel 文件数据不完整");
                }
            }

            // 3. 设置知识点ID和创建时间
            for (Question question : questionList) {
                question.setKnowledgeId(knowledgeId); // 设置知识点ID
                question.setType(type);
                question.setCreatedAt(new Date()); // 设置创建时间
            }

            // 4. 批量插入试题
            questionMapper.insertBatch(questionList);
        } catch (IOException e) {
            throw new RuntimeException("解析 Excel 文件失败", e);
        } catch (Exception e) {
            throw new RuntimeException("导入失败：" + e.getMessage(), e);
        }
    }

    @Override
    public List<Question> listQuestionsByIds(List<Long> ids) {
        return questionMapper.selectQuestionsByIds(ids);
    }

}
