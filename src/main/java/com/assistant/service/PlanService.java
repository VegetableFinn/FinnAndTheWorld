package com.assistant.service;

import java.util.Date;

import com.assistant.models.result.BaseServiceResult;
import com.assistant.models.result.PlanQueryResult;

/**
 * @author hefan.hf
 * @version $Id: PlanService, v 0.1 16/5/8 14:45 hefan.hf Exp $
 */
public interface PlanService {

    /**
     * 新增计划
     * @param content
     * @param total
     * @param unit
     * @return
     */
    BaseServiceResult add(String content, int total, String unit, Date startDt, Date endDt);

    /**
     * 获取生效计划
     * @return
     */
    PlanQueryResult getActivePlans();
}