/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.assistant.models.core;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.executor.ErrorContext;

/**
 * 操作上下文.
 * @author hefan.hf
 * @version $Id: Context, v 0.1 16/4/16 20:28 hefan.hf Exp $
 */
public class Context implements Serializable {

    /** 序列化 */
    private static final long serialVersionUID = 8770241885006354359L;

    /** 操作时间 */
    private Date              date;

    /** 错误码上下文 */
    private ErrorContext      errorContext;

    /**
     * Getter method for property <tt>date</tt>.
     *
     * @return property value of date
     */

    public Date getDate() {
        return date;
    }

    /**
     * Setter method for property <tt>date</tt>.
     *
     * @param date value to be assigned to property date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter method for property <tt>errorContext</tt>.
     *
     * @return property value of errorContext
     */

    public ErrorContext getErrorContext() {
        return errorContext;
    }

    /**
     * Setter method for property <tt>errorContext</tt>.
     *
     * @param errorContext value to be assigned to property errorContext
     */
    public void setErrorContext(ErrorContext errorContext) {
        this.errorContext = errorContext;
    }
}