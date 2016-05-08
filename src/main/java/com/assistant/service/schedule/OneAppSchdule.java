package com.assistant.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.assistant.models.result.BaseServiceResult;
import com.assistant.service.OneAppService;
import com.assistant.service.impl.BaseService;

/**
 * @author hefan.hf
 * @version $Id: OneAppSchdule, v 0.1 16/4/16 23:13 hefan.hf Exp $
 */
@Service
public class OneAppSchdule extends BaseService {

    @Autowired
    private OneAppService oneAppService;

    /**
     * ONE更新调度
     */
    @Scheduled(cron = "0 0 0,8,12,20 * * ?")
    public void updateOneApp() {

        logger.info("开始调度执行更新ONE.");
        BaseServiceResult result = oneAppService.checkForNewOne();
        if (!result.isSuccess()) {
            logger.error("调度执行ONE更新失败.失败信息:" + result.getErrorMessageEnum());
        }
        logger.info("调度结束.");

    }

}