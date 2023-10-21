package com.cyan.springcloud.client.service;

import com.cyan.springcloud.model.entity.QuestionSubmit;

/**
 * 判题服务
 *
 * @author Cyan Chau
 * @create 2023-10-17
 */
public interface JudgeService {

    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);

}
