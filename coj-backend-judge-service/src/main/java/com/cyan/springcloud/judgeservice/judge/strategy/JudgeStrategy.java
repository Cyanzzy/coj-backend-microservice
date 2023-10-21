package com.cyan.springcloud.judgeservice.judge.strategy;

import com.cyan.springcloud.model.codesandbox.JudgeInfo;

/**
 * 判题策略
 *
 * @author Cyan Chau
 * @create 2023-10-17
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     *
     * @param context
     * @return
     */
    JudgeInfo doJudge(JudgeContext context);
}
