package com.cyan.springcloud.judgeservice.judge.codesandbox;

import com.cyan.springcloud.model.codesandbox.ExecuteCodeRequest;
import com.cyan.springcloud.model.codesandbox.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 代码沙箱代理类
 *
 * @author Cyan Chau
 * @create 2023-10-17
 */

@Slf4j
public class CodeSandboxProxy implements CodeSandbox {

    private CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest request) {

        log.info("代码沙箱请求消息：" + request.toString());
        ExecuteCodeResponse response = codeSandbox.executeCode(request);
        log.info("代码沙箱响应消息：" + response.toString());

        return response;
    }
}
