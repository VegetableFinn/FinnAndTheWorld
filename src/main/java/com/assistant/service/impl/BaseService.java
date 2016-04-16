package com.assistant.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.assistant.models.core.Context;
import com.assistant.models.core.ContextHolder;
import com.assistant.service.CommonService;

/**
 * 服务基类.
 * @author hefan.hf
 * @version $Id: BaseService, v 0.1 16/4/16 20:30 hefan.hf Exp $
 */
public class BaseService {

    /** logger */
    protected static Logger logger      = Logger.getLogger(BaseService.class);

    /** errorlogger */
    protected static Logger errorLogger = Logger.getLogger("errorlogger");

    @Autowired
    private CommonService   commonService;

    //~~~父类方法

    /**
     * 初始化线程环境
     */
    protected void initContext() {

        ContextHolder.set(new Context());
        ContextHolder.get().setDate(commonService.getSysDate());

    }
}