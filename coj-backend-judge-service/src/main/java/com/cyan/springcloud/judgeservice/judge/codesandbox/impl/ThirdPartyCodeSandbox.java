package com.cyan.springcloud.judgeservice.judge.codesandbox.impl;


import com.cyan.springcloud.judgeservice.judge.codesandbox.CodeSandbox;
import com.cyan.springcloud.model.codesandbox.ExecuteCodeRequest;
import com.cyan.springcloud.model.codesandbox.ExecuteCodeResponse;

/**
 * 第三方代码沙箱
 *
 * @author Cyan Chau
 * @create 2023-10-17
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
