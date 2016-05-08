package com.assistant.service;

import com.assistant.models.result.BaseServiceResult;

/**
 * @author hefan.hf
 * @version $Id: PlanService, v 0.1 16/5/8 14:45 hefan.hf Exp $
 */
public interface PlanService {

    BaseServiceResult add(String content, String period, int total, String unit);

}