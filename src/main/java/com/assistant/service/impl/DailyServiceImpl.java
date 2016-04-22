/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.assistant.service.impl;

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
        return dailyMapper.endById(id);
    }
}