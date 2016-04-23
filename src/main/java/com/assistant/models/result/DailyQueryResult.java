package com.assistant.models.result;

import java.util.List;

import com.assistant.models.daily.DailyModel;

/**
 * @author hefan.hf
 * @version $Id: DailyQueryResult, v 0.1 16/4/23 18:49 hefan.hf Exp $
 */
public class DailyQueryResult extends BaseServiceResult {

    private List<DailyModel> dailyModels;

    public DailyQueryResult() {
        super();
    }

    /**
     * Getter method for property <tt>dailyModels</tt>.
     *
     * @return property value of dailyModels
     */

    public List<DailyModel> getDailyModels() {
        return dailyModels;
    }

    /**
     * Setter method for property <tt>dailyModels</tt>.
     *
     * @param dailyModels value to be assigned to property dailyModels
     */
    public void setDailyModels(List<DailyModel> dailyModels) {
        this.dailyModels = dailyModels;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DailyQueryResult{");
        sb.append("dailyModels=").append(dailyModels);
        sb.append('}');
        return sb.toString();
    }
}