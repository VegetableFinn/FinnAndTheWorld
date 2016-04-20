package com.assistant.models.enums;

/**
 * @author hefan.hf
 * @version $Id: ErrorMessageEnum, v 0.1 16/4/16 19:43 hefan.hf Exp $
 */
public enum ErrorMessageEnum {

    /** 执行成功 */
    SUCCESS("SUCCESS", "执行成功"),

    /** 系统异常 */
    UNKNOWN_EXCEPTION("UNKNOWN_EXCEPTION", "系统异常"),

    /** 登录失败 */
    LOGIN_FAIL("LOGIN_FAIL", "登录失败"),

    ;

    /**
     * 默认构造函数
     * @param code
     * @param description
     */
    ErrorMessageEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /** 错误码 */
    private String code;

    /** 描述 */
    private String description;

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */

    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>description</tt>.
     *
     * @return property value of description
     */

    public String getDescription() {
        return description;
    }

    /**
     * Setter method for property <tt>description</tt>.
     *
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}