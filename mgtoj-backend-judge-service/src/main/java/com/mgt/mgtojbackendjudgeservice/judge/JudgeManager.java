package com.mgt.mgtojbackendjudgeservice.judge;

import com.mgt.mgtojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.mgt.mgtojbackendjudgeservice.judge.strategy.CLanguageJudgeStrategy;
import com.mgt.mgtojbackendjudgeservice.judge.strategy.CppLanguageJudgeStrategy;
import com.mgt.mgtojbackendjudgeservice.judge.strategy.PythonLanguageJudgeStrategy;
import com.mgt.mgtojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.mgt.mgtojbackendjudgeservice.judge.strategy.JudgeContext;
import com.mgt.mgtojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.mgt.mgtojbackendmodel.model.codesandbox.JudgeInfo;
import com.mgt.mgtojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        } else if ("python".equals(language)) {
            judgeStrategy = new PythonLanguageJudgeStrategy();
        } else if ("cpp".equals(language)) {
            judgeStrategy = new CppLanguageJudgeStrategy();
        } else if ("c".equals(language)) {
            judgeStrategy = new CLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
