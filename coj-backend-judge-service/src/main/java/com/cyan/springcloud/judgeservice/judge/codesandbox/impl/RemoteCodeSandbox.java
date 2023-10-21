package com.cyan.springcloud.judgeservice.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.cyan.springcloud.common.commons.ErrorCode;
import com.cyan.springcloud.common.exception.BusinessException;
import com.cyan.springcloud.judgeservice.judge.codesandbox.CodeSandbox;
import com.cyan.springcloud.model.codesandbox.ExecuteCodeRequest;
import com.cyan.springcloud.model.codesandbox.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * 远程代码沙箱
 *
 * @author Cyan Chau
 */
public class RemoteCodeSandbox implements CodeSandbox {


    // 定义鉴权请求头
    private static final String AUTH_REQUEST_HEADER = "auth";

    // 定义鉴权请求密钥
    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");

        String url = "http://localhost:8080/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, response = {}" + responseStr);
        }

        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
