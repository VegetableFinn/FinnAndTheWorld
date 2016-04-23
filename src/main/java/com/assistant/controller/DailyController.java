package com.assistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistant.models.result.BaseServiceResult;
import com.assistant.models.result.DailyQueryResult;
import com.assistant.service.DailyService;

/**
 * @author hefan.hf
 * @version $Id: DailyController, v 0.1 16/4/22 17:58 hefan.hf Exp $
 */
@Controller
@RequestMapping("/daily")
public class DailyController extends BaseController {

    @Autowired
    private DailyService dailyService;

    @RequestMapping("/getRecent2Days")
    public @ResponseBody DailyQueryResult getRecentTwoDaysOrderByDt() {
        return dailyService.getRecentTwoDaysOrderByDt();
    }

    @RequestMapping("/endDaily")
    public @ResponseBody BaseServiceResult endDaily(int id) {
        return dailyService.endById(id);
    }

    @RequestMapping("/addDaily")
    public @ResponseBody BaseServiceResult addDaily(String type, String isDuration, String content) {
        return dailyService.addDaily(type, isDuration, content);
    }

    @RequestMapping("/editDaily")
    public @ResponseBody BaseServiceResult editDaily(String type, String content, int id) {
        return dailyService.editDaily(type, content, id);
    }

}