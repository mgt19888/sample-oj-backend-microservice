package com.mgt.mgtojbackendjudgeservice.judge.codesandbox;

import com.mgt.mgtojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.mgt.mgtojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
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
