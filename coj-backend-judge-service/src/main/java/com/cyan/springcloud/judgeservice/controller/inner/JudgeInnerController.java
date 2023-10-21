package com.cyan.springcloud.judgeservice.controller.inner;

import com.cyan.springcloud.client.service.JudgeFeignClient;
import com.cyan.springcloud.judgeservice.judge.JudgeService;
import com.cyan.springcloud.model.entity.QuestionSubmit;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 服务内部互相调用的接口
 *
 * @author Cyan Chau
 * @create 2023-10-21
 */
@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;

    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    @PostMapping("/do")
    @Override
    public QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId) {

        return judgeService.doJudge(questionSubmitId);
    }

}
