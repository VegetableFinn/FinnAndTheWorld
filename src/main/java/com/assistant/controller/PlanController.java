package com.assistant.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistant.models.result.BaseServiceResult;
import com.assistant.models.result.PlanQueryResult;
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
    public @ResponseBody BaseServiceResult addPlan(String content, int total, String unit,
                                                   Date startDt, Date endDt) {
        return planService.add(content, total, unit, startDt, endDt);
    }

    @RequestMapping("/getActivePlans")
    public @ResponseBody PlanQueryResult getActivePlans() {
        return planService.getActivePlans();
    }

    @RequestMapping("/startPlan")
    public @ResponseBody BaseServiceResult startPlan(int id) {
        return planService.startPlan(id);
    }

}