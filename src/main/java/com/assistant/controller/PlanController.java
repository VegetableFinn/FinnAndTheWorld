package com.assistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistant.models.result.BaseServiceResult;
import com.assistant.service.PlanService;

/**
 * @author hefan.hf
 * @version $Id: PlanController, v 0.1 16/5/8 14:47 hefan.hf Exp $
 */
@Controller
@RequestMapping("/plan")
public class PlanController extends BaseController {

    @Autowired
    private PlanService planService;

    @RequestMapping("/addPlan")
    public @ResponseBody BaseServiceResult addPlan(String content, String period, int total,
                                                   String unit) {
        return planService.add(content, period, total, unit);
    }

}