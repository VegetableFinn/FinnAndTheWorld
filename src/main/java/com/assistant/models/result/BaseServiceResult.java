package com.assistant.models.result;

import java.io.Serializable;

import com.assistant.models.enums.ErrorMessageEnum;

/**
 * 基本结果对象.
 * @author hefan.hf
 * @version $Id: BaseServiceResult, v 0.1 16/4/16 19:40 hefan.hf Exp $
 */
public class BaseServiceResult implements Serializable {

    /** 序列化 */
    private static final long serialVersionUID = -6463196641114250303L;

    /** 结果是否成功 */
    private boolean           success;

    /** 错误描述 */
    private ErrorMessageEnum  errorMessageEnum;

    /**
     * 默认构造函数
     */
    public BaseServiceResult() {
        this.success = true;
        this.errorMessageEnum = ErrorMessageEnum.SUCCESS;
    }

    /**
     * Getter method for property <tt>success</tt>.
     *
     * @return property value of success
     */

    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter method for property <tt>success</tt>.
     *
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Getter method for property <tt>errorMessageEnum</tt>.
     *
     * @return property value of errorMessageEnum
     */

    public ErrorMessageEnum getErrorMessageEnum() {
        return errorMessageEnum;
    }

    /**
     * Setter method for property <tt>errorMessageEnum</tt>.
     *
     * @param errorMessageEnum value to be assigned to property errorMessageEnum
     */
    public void setErrorMessageEnum(ErrorMessageEnum errorMessageEnum) {
        this.errorMessageEnum = errorMessageEnum;
    }
}