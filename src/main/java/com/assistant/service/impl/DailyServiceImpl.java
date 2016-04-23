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
    public List<DailyModel> getRecentTwoDaysOrderByDt() {
        List<Daily> dailies = dailyMapper.selectRecent2DaysDesc();
        return DailyConvertor.convertToModels(dailies);
    }

    @Override
    public int endById(int id) {
        Date now = commonService.getSysDate();
        Daily daily = dailyMapper.selectByPrimaryKey(id);
        daily.setEndDt(now);
        daily.setGmtModified(now);
        return dailyMapper.updateByPrimaryKey(daily);
    }

    @Override
    public void addDaily(String type, String isDuration, String content) {

        Date now = commonService.getSysDate();

        Daily daily = new Daily();
        daily.setCatagory(type);
        daily.setContent(content);
        daily.setIsDuration(isDuration);
        daily.setGmtCreate(now);
        daily.setGmtModified(now);
        daily.setStartDt(now);

        dailyMapper.insert(daily);
    }
}