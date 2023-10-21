package com.cyan.springcloud.judgeservice.judge.codesandbox.impl;

import com.cyan.springcloud.judgeservice.judge.codesandbox.CodeSandbox;
import com.cyan.springcloud.model.codesandbox.ExecuteCodeRequest;
import com.cyan.springcloud.model.codesandbox.ExecuteCodeResponse;
import com.cyan.springcloud.model.codesandbox.JudgeInfo;
import com.cyan.springcloud.model.enums.JudgeInfoMessageEnum;
import com.cyan.springcloud.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱
 *
 * @author Cyan Chau
 */
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {

        List<String> inputList = executeCodeRequest.getInputList();
        String code = executeCodeRequest.getCode();
        String language = executeCodeRequest.getLanguage();

        ExecuteCodeResponse response = new ExecuteCodeResponse();
        response.setOutputList(inputList);
        response.setMessage("测试执行成功");
        response.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());

        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        response.setJudgeInfo(judgeInfo);

        return response;
    }
}
