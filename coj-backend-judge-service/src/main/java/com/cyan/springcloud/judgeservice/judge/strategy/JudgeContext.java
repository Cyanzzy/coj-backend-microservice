package com.cyan.springcloud.judgeservice.judge.strategy;

import com.cyan.springcloud.model.codesandbox.JudgeInfo;
import com.cyan.springcloud.model.dto.question.JudgeCase;
import com.cyan.springcloud.model.entity.Question;
import com.cyan.springcloud.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文信息：用于定义在策略中传递的参数
 *
 * @author Cyan Chau
 * @create 2023-10-17
 */
@Data
public class JudgeContext {

    /**
     * 判题信息
     */
    private JudgeInfo judgeInfo;

    /**
     * 输入用例
     */
    private List<String> inputList;

    /**
     * 输出用例
     */
    private List<String> outputList;

    /**
     * 判题用例
     */
    private List<JudgeCase> judgeCaseList;

    /**
     * 问题
     */
    private Question question;

    /**
     * 题目提交信息
     */
    private QuestionSubmit questionSubmit;

}
