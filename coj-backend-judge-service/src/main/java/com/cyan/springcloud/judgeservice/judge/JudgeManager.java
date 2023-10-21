package com.cyan.springcloud.judgeservice.judge;

import com.cyan.springcloud.judgeservice.judge.strategy.DefaultJudgeStrategy;
import com.cyan.springcloud.judgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.cyan.springcloud.judgeservice.judge.strategy.JudgeContext;
import com.cyan.springcloud.judgeservice.judge.strategy.JudgeStrategy;
import com.cyan.springcloud.model.codesandbox.JudgeInfo;
import com.cyan.springcloud.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理：简化对判题逻辑的的调用
 *
 * @author Cyan Chau
 * @create 2023-10-17
 */
@Service
public class JudgeManager {

    JudgeInfo doJudge(JudgeContext judgeContext) {

        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();

        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }

        return judgeStrategy.doJudge(judgeContext);
    }
}
