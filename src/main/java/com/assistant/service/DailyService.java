package com.assistant.service;

import com.assistant.db.model.Daily;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.models.result.DailyQueryResult;

/**
 * @author hefan.hf
 * @version $Id: DailyService, v 0.1 16/4/22 18:06 hefan.hf Exp $
 */
public interface DailyService {

    DailyQueryResult getRecentTwoDaysOrderByDt();

    BaseServiceResult endById(int id);

    BaseServiceResult addDaily(String type, String isDuration, String content);

    BaseServiceResult editDaily(String type, String content, int id);

    BaseServiceResult deleteDaily(int id);

    Daily selectByContent(Daily record);
}
