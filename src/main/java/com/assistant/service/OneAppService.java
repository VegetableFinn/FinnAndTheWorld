package com.assistant.service;

import java.util.List;

import com.assistant.db.model.OneApp;
import com.assistant.models.result.BaseServiceResult;

/**
 * @author hefan.hf
 * @version $Id: OneAppService, v 0.1 16/4/16 19:15 hefan.hf Exp $
 */
public interface OneAppService {

    /**
     * 捞取所有
     * @return
     */
    List<OneApp> selectByAll();

    /**
     * 更新one记录
     * @return
     */
    BaseServiceResult checkForNewOne();

}