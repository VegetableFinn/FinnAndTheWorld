/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.assistant.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistant.db.dao.DailyMapper;
import com.assistant.db.model.Daily;
import com.assistant.models.daily.DailyModel;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.models.result.DailyQueryResult;
import com.assistant.service.DailyService;
import com.assistant.utils.convertor.DailyConvertor;

/**
 * @author hefan.hf
 * @version $Id: DailyServiceImpl, v 0.1 16/4/22 18:07 hefan.hf Exp $
 */
@Service("dailyService")
public class DailyServiceImpl extends BaseService implements DailyService {

    @Autowired
    private DailyMapper dailyMapper;

    @Override
    public DailyQueryResult getRecentTwoDaysOrderByDt() {
        DailyQueryResult result = new DailyQueryResult();
        List<Daily> dailies = dailyMapper.selectRecent2DaysDesc();
        List<DailyModel> dailyModels = DailyConvertor.convertToModels(dailies);
        result.setDailyModels(dailyModels);
        return result;
    }

    @Override
    public BaseServiceResult endById(int id) {
        BaseServiceResult result = new BaseServiceResult();
        Date now = commonService.getSysDate();
        Daily daily = dailyMapper.selectByPrimaryKey(id);
        daily.setEndDt(now);
        daily.setGmtModified(now);
        dailyMapper.updateByPrimaryKey(daily);
        return result;
    }

    @Override
    public BaseServiceResult addDaily(String type, String isDuration, String content) {

        BaseServiceResult result = new BaseServiceResult();

        Date now = commonService.getSysDate();

        Daily daily = new Daily();
        daily.setCatagory(type);
        daily.setContent(content);
        daily.setIsDuration(isDuration);
        daily.setGmtCreate(now);
        daily.setGmtModified(now);
        daily.setStartDt(now);

        dailyMapper.insert(daily);

        return result;
    }

    @Override
    public BaseServiceResult editDaily(String type, String content, int id) {
        BaseServiceResult result = new BaseServiceResult();
        Date now = commonService.getSysDate();
        Daily daily = dailyMapper.selectByPrimaryKey(id);
        daily.setGmtModified(now);
        daily.setCatagory(type);
        daily.setContent(content);
        dailyMapper.updateByPrimaryKey(daily);
        return result;
    }

    @Override
    public BaseServiceResult deleteDaily(int id) {
        BaseServiceResult result = new BaseServiceResult();
        dailyMapper.deleteByPrimaryKey(id);
        return result;
    }
}