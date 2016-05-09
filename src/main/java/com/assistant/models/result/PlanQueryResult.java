package com.assistant.models.result;

import java.util.List;

import com.assistant.models.plan.PlanModel;

/**
 * @author hefan.hf
 * @version $Id: PlanQueryResult, v 0.1 16/5/9 09:06 hefan.hf Exp $
 */
public class PlanQueryResult extends BaseServiceResult {

    private List<PlanModel> planList;

    public PlanQueryResult() {
        super();
    }

    /**
     * Getter method for property <tt>planList</tt>.
     *
     * @return property value of planList
     */

    public List<PlanModel> getPlanList() {
        return planList;
    }

    /**
     * Setter method for property <tt>planList</tt>.
     *
     * @param planList value to be assigned to property planList
     */
    public void setPlanList(List<PlanModel> planList) {
        this.planList = planList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PlanQueryResult{");
        sb.append("planList=").append(planList);
        sb.append('}');
        return sb.toString();
    }
}