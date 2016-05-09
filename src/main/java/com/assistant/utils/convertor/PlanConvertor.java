package com.assistant.utils.convertor;

import java.util.ArrayList;
import java.util.List;

import com.assistant.db.model.Plan;
import com.assistant.models.enums.PlanUnitEnum;
import com.assistant.models.enums.TrueFalseEnum;
import com.assistant.models.plan.PlanModel;
import com.assistant.utils.DateUtil;
import com.assistant.utils.NumberUtil;
import com.assistant.utils.StringUtil;

/**
 * @author hefan.hf
 * @version $Id: PlanConvertor, v 0.1 16/5/9 12:30 hefan.hf Exp $
 */
public class PlanConvertor {

    public static PlanModel convertToModel(Plan plan) {
        PlanModel model = new PlanModel();
        model.setContent(plan.getContent());
        model.setId(plan.getId());
        model.setStartDt(DateUtil.convertToPlanDtString(plan.getStartDt()));
        model.setEndDt(DateUtil.convertToPlanDtString(plan.getEndDt()));
        if (StringUtil.equals(plan.getIsFinished(), TrueFalseEnum.TRUE.getCode())) {
            model.setFinished(true);
        } else {
            model.setFinished(false);
        }

        model.setProgress(plan.getCurrent() + " / " + plan.getTotal() + " "
                          + PlanUnitEnum.getByCode(plan.getUnit()).getDescription());
        model.setPercent(NumberUtil.getPercent(plan.getCurrent(), plan.getTotal()));
        return model;
    }

    public static List<PlanModel> convertToModelList(List<Plan> planList) {
        List<PlanModel> planModelList = new ArrayList<PlanModel>();
        for (Plan plan : planList) {
            PlanModel planModel = convertToModel(plan);
            planModelList.add(planModel);
        }
        return planModelList;
    }
}