package com.assistant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.assistant.db.dao.OneAppMapper;
import com.assistant.db.model.OneApp;
import com.assistant.models.enums.ErrorMessageEnum;
import com.assistant.models.oneApps.OneAppJson;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.service.OneAppService;
import com.assistant.utils.HttpRequestUtil;
import com.assistant.utils.ResultHelper;
import com.assistant.utils.StringUtil;
import com.assistant.utils.convertor.OneAppConvertor;

/**
 * @author hefan.hf
 * @version $Id: OneAppServiceImpl, v 0.1 16/4/16 19:21 hefan.hf Exp $
 */
@Service("oneAppService")
public class OneAppServiceImpl extends BaseService implements OneAppService {

    @Autowired
    private OneAppMapper oneAppMapper;

    @Override
    public List<OneApp> selectByAll() {
        return oneAppMapper.selectAll();
    }

    @Override
    public BaseServiceResult checkForNewOne() {
        BaseServiceResult result = new BaseServiceResult();

        logger.info("收到ONE检查请求.");

        //1.初始化线程环境
        initContext();

        try {
            //2.取最后一条one记录
            OneApp oneApp = oneAppMapper.selectLastOne();

            //3.读取官网最新记录
            OneApp one = getLastOneFromWeb();
            Assert.notNull(one);

            //4.幂等
            if (StringUtil.equals(oneApp.getContent(), one.getContent())) {
                logger.info("ONE更新时幂等.[" + one + "]");
                return result;
            }

            //5.保存
            oneAppMapper.insert(one);
        } catch (Exception e) {
            logger.error("更新ONE失败.", e);
            ResultHelper.fillFailure(result, ErrorMessageEnum.UNKNOWN_EXCEPTION);
        }

        logger.info("ONE检查结束.");

        return result;
    }

    /**
     * 从官网获取最新记录
     * @return
     */
    private OneApp getLastOneFromWeb() {
        OneApp oneApp = null;
        try {
            String response = HttpRequestUtil.sendGet("http://v3.wufazhuce.com:8000/api/hp/more/0");
            OneAppJson json = JSON.parseObject(response, OneAppJson.class);
            Assert.notNull(json.getData().get(0));
            oneApp = OneAppConvertor.toOneApp(json.getData().get(0));

        } catch (Exception e) {
            logger.error("从ONE官网获取最新记录失败.", e);
        }

        return oneApp;
    }
}