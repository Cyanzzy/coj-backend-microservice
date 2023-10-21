package com.cyan.springcloud.judgeservice.judge.codesandbox;

import com.cyan.springcloud.model.codesandbox.ExecuteCodeRequest;
import com.cyan.springcloud.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱通用接口
 *
 * @author Cyan Chau
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
