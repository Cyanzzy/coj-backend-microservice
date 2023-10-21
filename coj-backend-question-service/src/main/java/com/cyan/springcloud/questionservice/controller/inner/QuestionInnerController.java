package com.cyan.springcloud.questionservice.controller.inner;

import com.cyan.springcloud.client.service.QuestionFeignClient;
import com.cyan.springcloud.model.entity.Question;
import com.cyan.springcloud.model.entity.QuestionSubmit;
import com.cyan.springcloud.questionservice.service.QuestionService;
import com.cyan.springcloud.questionservice.service.QuestionSubmitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 服务内部互相调用的接口
 *
 * @author Cyan Chau
 * @create 2023-10-21
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    /**
     * 根据 id 获取问题
     *
     * @param questionId
     * @return
     */
    @GetMapping("/get/id")
    @Override
    public Question getQuestionById(@RequestParam("questionId") long questionId) {

        return questionService.getById(questionId);
    }

    /**
     * 根据 id 获取提交的问题
     *
     * @param questionSubmitId
     * @return
     */
    @GetMapping("/question_submit/get/id")
    @Override
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId) {

        return questionSubmitService.getById(questionSubmitId);
    }

    /**
     * 更新提交的问题
     *
     * @param questionSubmit
     * @return
     */
    @PostMapping("/question_submit/update")
    @Override
    public boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit) {

        return questionSubmitService.updateById(questionSubmit);
    }

}
