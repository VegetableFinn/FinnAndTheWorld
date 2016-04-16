package com.assistant.utils;

import com.assistant.models.enums.ErrorMessageEnum;
import com.assistant.models.result.BaseServiceResult;

/**
 * 结果工具类
 * @author hefan.hf
 * @version $Id: ResultHelper, v 0.1 16/4/16 22:49 hefan.hf Exp $
 */
public class ResultHelper {

    /**
     * 填充成功结果
     * @param result
     */
    public static void fillSuccess(BaseServiceResult result) {
        result.setSuccess(true);
        result.setErrorMessageEnum(ErrorMessageEnum.SUCCESS);
    }

    /**
     * 填充失败结果
     * @param result
     * @param error
     */
    public static void fillFailure(BaseServiceResult result, ErrorMessageEnum error) {
        result.setSuccess(false);
        result.setErrorMessageEnum(error);
    }

}