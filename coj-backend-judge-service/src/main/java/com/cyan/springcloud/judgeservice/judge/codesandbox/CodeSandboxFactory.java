package com.cyan.springcloud.judgeservice.judge.codesandbox;

import com.cyan.springcloud.judgeservice.judge.codesandbox.impl.ExampleCodeSandbox;
import com.cyan.springcloud.judgeservice.judge.codesandbox.impl.RemoteCodeSandbox;
import com.cyan.springcloud.judgeservice.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱工厂
 *
 * @author Cyan Chau
 * @create 2023-10-17
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱
     *
     * @return 沙箱类型
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
