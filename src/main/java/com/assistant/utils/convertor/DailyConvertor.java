package com.assistant.utils.convertor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.assistant.db.model.Daily;
import com.assistant.models.daily.DailyModel;
import com.assistant.models.enums.TrueFalseEnum;

/**
 * @author hefan.hf
 * @version $Id: DailyConvertor, v 0.1 16/4/22 18:31 hefan.hf Exp $
 */
public class DailyConvertor {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static DailyModel convertToModel(Daily daily) {
        DailyModel model = new DailyModel();
        model.setContent(daily.getContent());
        model.setCatagory(daily.getCatagory());
        if (daily.getEndDt() != null) {
            model.setEndDt(sdf.format(daily.getEndDt()));
        }
        model.setId(daily.getId());
        model.setDuration(TrueFalseEnum.getByCode(daily.getIsDuration()).getDescription());
        model.setStartDt(sdf.format(daily.getStartDt()));
        return model;
    }

    public static List<DailyModel> convertToModels(List<Daily> dailies) {
        List<DailyModel> dailyModels = new ArrayList<DailyModel>();
        for (Daily daily : dailies) {
            dailyModels.add(convertToModel(daily));
        }
        return dailyModels;
    }

}