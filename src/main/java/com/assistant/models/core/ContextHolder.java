/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.assistant.models.core;

/**
 * 服务上下文
 * @author hefan.hf
 * @version $Id: ContextHolder, v 0.1 16/4/16 20:27 hefan.hf Exp $
 */
public class ContextHolder {

    /** 本地线程 */
    private static ThreadLocal<Context> local = new ThreadLocal<Context>();

    /**
     * 默认构造函数
     */
    public ContextHolder() {
    }

    /**
     *
     * 取得操作上下文
     *
     * @return 会员操作上下文
     */
    public static Context get() {
        return local.get();
    }

    /**
     * 设置操作上下文
     *
     * @param context
     */
    public static void set(Context context) {
        local.set(context);
    }

    /**
     * 清空上下文
     */
    public static void clear() {
        local.set(null);
    }

}