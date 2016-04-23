package com.assistant.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public @ResponseBody Object getRecentTwoDaysOrderByDt() {
        return dailyService.getRecentTwoDaysOrderByDt();
    }

    @RequestMapping("/endDaily")
    public @ResponseBody Object endDaily(int id) {
        return dailyService.endById(id);
    }

    @RequestMapping("/addDaily")
    public @ResponseBody void addDaily(String type, String isDuration, String content)
                                                                                      throws UnsupportedEncodingException {
        content = new String(content.getBytes("ISO-8859-1"), "UTF-8");
        dailyService.addDaily(type, isDuration, content);
    }

}