package com.assistant.models.enums;

import com.assistant.utils.StringUtil;

/**
 * @author hefan.hf
 * @version $Id: PlanUnitEnum, v 0.1 16/5/9 12:37 hefan.hf Exp $
 */
public enum PlanUnitEnum {

    /** 分钟 */
    MINUTE("M", "分钟"),

    /** 小时 */
    HOUR("H", "小时"),

    /** 次 */
    COUNT("C", "次")

    ;

    PlanUnitEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /** 编码 */
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

    public static PlanUnitEnum getByCode(String code) {
        for (PlanUnitEnum e : values()) {
            if (StringUtil.equals(e.getCode(), code)) {
                return e;
            }
        }
        return null;
    }

}