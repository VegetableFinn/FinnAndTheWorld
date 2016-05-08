package com.assistant.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistant.db.dao.PlanMapper;
import com.assistant.db.model.Plan;
import com.assistant.models.enums.TrueFalseEnum;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.service.PlanService;

/**
 * @author hefan.hf
 * @version $Id: PlanServiceImpl, v 0.1 16/5/8 14:46 hefan.hf Exp $
 */
@Service("planService")
public class PlanServiceImpl extends BaseService implements PlanService {

    @Autowired
    private PlanMapper planMapper;

    @Override
    public BaseServiceResult add(String content, String period, int total, String unit) {
        BaseServiceResult result = new BaseServiceResult();

        Date now = commonService.getSysDate();

        Plan plan = new Plan();
        plan.setGmtModified(now);
        plan.setContent(content);
        plan.setGmtCreate(now);
        plan.setCurrent(0);
        plan.setIsFinished(TrueFalseEnum.FALSE.getCode());
        plan.setPeriod(period);
        plan.setTotal(total);
        plan.setUnit(unit);

        planMapper.insert(plan);

        return result;
    }
}