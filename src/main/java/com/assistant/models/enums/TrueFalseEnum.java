package com.assistant.models.enums;

import com.assistant.utils.StringUtil;

/**
 * @author hefan.hf
 * @version $Id: ErrorMessageEnum, v 0.1 16/4/16 19:43 hefan.hf Exp $
 */
public enum TrueFalseEnum {

    /** TRUE */
    TRUE("T", true),

    /** FALSE */
    FALSE("F", false),

    ;

    /**
     * 默认构造函数
     * @param code
     * @param description
     */
    TrueFalseEnum(String code, boolean description) {
        this.code = code;
        this.description = description;
    }

    /** 错误码 */
    private String  code;

    /** 描述 */
    private boolean description;

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

    public boolean getDescription() {
        return description;
    }

    /**
     * Setter method for property <tt>description</tt>.
     *
     * @param description value to be assigned to property description
     */
    public void setDescription(boolean description) {
        this.description = description;
    }

    public static TrueFalseEnum getByCode(String code) {
        for (TrueFalseEnum e : values()) {
            if (StringUtil.equals(e.getCode(), code)) {
                return e;
            }
        }
        return null;
    }
}