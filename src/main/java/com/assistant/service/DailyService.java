package com.assistant.service;

import java.util.List;

import com.assistant.models.daily.DailyModel;

/**
 * @author hefan.hf
 * @version $Id: DailyService, v 0.1 16/4/22 18:06 hefan.hf Exp $
 */
public interface DailyService {

    List<DailyModel> getRecentTwoDaysOrderByDt();

    int endById(int id);

}