package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Exams;
import com.ruoyi.system.domain.Paper;
import com.ruoyi.system.domain.Question;
import com.ruoyi.system.mapper.ExamsMapper;
import com.ruoyi.system.mapper.PaperMapper;
import com.ruoyi.system.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ExamScoreMapper;
import com.ruoyi.system.domain.ExamScore;
import com.ruoyi.system.service.IExamScoreService;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.core.type.TypeReference;
/**
 * 考试得分记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-28
 */
@Service
public class ExamScoreServiceImpl implements IExamScoreService
{
    @Autowired
    private ExamScoreMapper examScoreMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private ExamsMapper examsMapper;

    @Autowired
    private ObjectMapper objectMapper;
    /**
     * 查询考试得分记录
     *
     * @param id 考试得分记录主键
     * @return 考试得分记录
     */
    @Override
    public ExamScore selectExamScoreById(Long id)
    {
        return examScoreMapper.selectExamScoreById(id);
    }

    /**
     * 查询考试得分记录列表
     *
     * @param examScore 考试得分记录
     * @return 考试得分记录
     */
    @Override
    public List<ExamScore> selectExamScoreList(ExamScore examScore)
    {
        return examScoreMapper.selectExamScoreList(examScore);
    }

    /**
     * 新增考试得分记录
     *
     * @param examScore 考试得分记录
     * @return 结果
     */
    @Override
    public int insertExamScore(ExamScore examScore)
    {
        examScore.setCreateTime(DateUtils.getNowDate());
        return examScoreMapper.insertExamScore(examScore);
    }

    /**
     * 修改考试得分记录
     *
     * @param examScore 考试得分记录
     * @return 结果
     */
    @Override
    public int updateExamScore(ExamScore examScore)
    {
        return examScoreMapper.updateExamScore(examScore);
    }

    /**
     * 批量删除考试得分记录
     *
     * @param ids 需要删除的考试得分记录主键
     * @return 结果
     */
    @Override
    public int deleteExamScoreByIds(Long[] ids)
    {
        return examScoreMapper.deleteExamScoreByIds(ids);
    }

    /**
     * 删除考试得分记录信息
     *
     * @param id 考试得分记录主键
     * @return 结果
     */
    @Override
    public int deleteExamScoreById(Long id)
    {
        return examScoreMapper.deleteExamScoreById(id);
    }


    // ExamScoreServiceImpl.java
    @Override
    @Transactional
    public int saveOrUpdateExamScore(ExamScore examScore) {
        // 1. 验证考试和试卷
        Exams exam = examsMapper.selectExamsByExamId(examScore.getExamId());
        if (exam == null) {
            throw new RuntimeException("考试不存在");
        }

        Paper paper = paperMapper.selectPaperById(exam.getPaperId());
        if (paper == null || StringUtils.isBlank(paper.getRules())) {
            throw new RuntimeException("试卷规则不存在");
        }

        // 2. 解析试卷规则
        Map<Integer, Integer> scoreMap = parsePaperRules(paper.getRules());
        System.out.println(666);
        System.out.println(scoreMap);
        // 3. 获取试题信息
        Question question = questionMapper.selectQuestionById(examScore.getQuestionId());
        if (question == null) {
            throw new RuntimeException("试题不存在");
        }

        System.out.println(question.getType());
        // 4. 获取题目分值
        // 将 question.getType() 转换为 int 类型以匹配 scoreMap 的键类型
        Integer fullScore = scoreMap.getOrDefault(Math.toIntExact(question.getType()), 0);
        System.out.println(fullScore);
        System.out.println(777);
        if (fullScore <= 0) {
            throw new RuntimeException("题型[" + question.getType() + "]未配置有效分数");
        }

        // 5. 计算得分
        examScore.setScore(BigDecimal.valueOf(
                calculateScore(
                        examScore.getUserAnswer(),
                        question.getCorrectAnswer(),
                        question,
                        fullScore
                )
        ));

        // 6. 保存或更新
        return Optional.ofNullable(
                        examScoreMapper.selectByUserAndQuestion(
                                examScore.getExamId(),
                                examScore.getUserId(),
                                examScore.getQuestionId()
                        ))
                .map(existing -> {
                    examScore.setId(existing.getId());
                    return examScoreMapper.updateExamScore(examScore);
                })
                .orElseGet(() -> {
                    examScore.setCreateTime(DateUtils.getNowDate());
                    return examScoreMapper.insertExamScore(examScore);
                });
    }



    private int calculateScore(String userAnswer, String correctAnswer,
                               Question question, int fullScore) {
        // 获取题型（安全转换）
        int questionType = question.getType() == null ? 0 : question.getType().intValue();
        // 统一答案格式
        String processedUser = StringUtils.trimToEmpty(userAnswer).toUpperCase();
        String processedCorrect = StringUtils.trimToEmpty(correctAnswer).toUpperCase();

        switch (questionType) {
            case 0: // 单选题
            case 1: // 判断题
                return processedUser.equals(processedCorrect) ? fullScore : 0;

            case 2: // 多选题
                return calculateMultiChoiceScore(processedUser, processedCorrect, fullScore);

            default:
                throw new IllegalArgumentException("不支持的题型代码: " + questionType);
        }
    }

    /**
     * 多选题计分逻辑
     */
    private int calculateMultiChoiceScore(String userAnswer, String correctAnswer, int fullScore) {
        // 1. 标准化答案格式（去除空格、统一大小写、排序）
        String processedUser = StringUtils.deleteWhitespace(userAnswer).toUpperCase();
        String processedCorrect = StringUtils.deleteWhitespace(correctAnswer).toUpperCase();

        // 2. 处理空答案
        if (StringUtils.isBlank(processedUser)) {
            return 0;
        }

        // 3. 分割答案（兼容有无逗号的情况）
        Set<String> userAnswers = splitAnswers(processedUser);
        Set<String> correctAnswers = splitAnswers(processedCorrect);

        // 4. 计算得分
        if (userAnswers.equals(correctAnswers)) {
            return fullScore; // 完全正确
        }

        // 计算正确选项数
        long correctCount = userAnswers.stream()
                .filter(correctAnswers::contains)
                .count();

        if (correctCount == 0) {
            return 0; // 完全错误
        }

        // 部分正确的情况
        boolean hasWrongAnswer = userAnswers.size() > correctCount;
        return hasWrongAnswer ? 0 : fullScore / 2;
    }

    /**
     * 分割答案字符串（兼容带逗号和不带逗号的情况）
     */
    private Set<String> splitAnswers(String answerStr) {
        // 如果包含逗号按逗号分割，否则按字符分割
        return answerStr.contains(",")
                ? new HashSet<>(Arrays.asList(answerStr.split(",")))
                : answerStr.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toSet());
    }

    private Map<Integer, Integer> parsePaperRules(String rulesJson) {
        try {
            List<Map<String, Object>> rules = objectMapper.readValue(
                    rulesJson,
                    new TypeReference<List<Map<String, Object>>>() {}
            );

            return rules.stream()
                    .filter(rule -> rule.containsKey("questionType") && rule.containsKey("questionScore"))
                    .collect(Collectors.toMap(
                            rule -> ((Number) rule.get("questionType")).intValue(),
                            rule -> ((Number) rule.get("questionScore")).intValue(),
                            (oldVal, newVal) -> oldVal
                    ));
        } catch (Exception e) {
            throw new RuntimeException("试卷规则解析失败: " + e.getMessage(), e);
        }
    }

}
