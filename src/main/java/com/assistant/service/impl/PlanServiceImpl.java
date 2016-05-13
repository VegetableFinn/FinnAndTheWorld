package com.assistant.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.assistant.db.dao.PlanMapper;
import com.assistant.db.model.Daily;
import com.assistant.db.model.Plan;
import com.assistant.models.enums.ErrorMessageEnum;
import com.assistant.models.enums.PlanUnitEnum;
import com.assistant.models.enums.TrueFalseEnum;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.models.result.PlanQueryResult;
import com.assistant.service.DailyService;
import com.assistant.service.PlanService;
import com.assistant.utils.DateUtil;
import com.assistant.utils.ResultHelper;
import com.assistant.utils.StringUtil;
import com.assistant.utils.convertor.PlanConvertor;

/**
 * @author hefan.hf
 * @version $Id: PlanServiceImpl, v 0.1 16/5/8 14:46 hefan.hf Exp $
 */
@Service("planService")
public class PlanServiceImpl extends BaseService implements PlanService {

    @Autowired
    private PlanMapper   planMapper;

    @Autowired
    private DailyService dailyService;

    @Override
    public BaseServiceResult add(String content, int total, String unit, Date startDt, Date endDt) {
        BaseServiceResult result = new BaseServiceResult();

        try {
            Date now = commonService.getSysDate();

            Plan plan = new Plan();
            plan.setGmtModified(now);
            plan.setContent(content);
            plan.setGmtCreate(now);
            plan.setCurrent(0);
            plan.setIsFinished(TrueFalseEnum.FALSE.getCode());
            if (StringUtil.equals(unit, PlanUnitEnum.HOUR.getCode())) {
                plan.setTotal(total * 60);
                plan.setUnit(PlanUnitEnum.MINUTE.getCode());
            } else {
                plan.setTotal(total);
                plan.setUnit(unit);
            }
            plan.setStartDt(DateUtil.convertFromPlanDtStart(startDt));
            plan.setEndDt(DateUtil.convertFromPlanDtEnd(endDt));
            planMapper.insert(plan);
        } catch (ParseException e) {
            e.printStackTrace();
            logger.error("添加计划时时间格式转换出错!startDt=[" + startDt + "],endDt=[" + endDt + "].", e);
            ResultHelper.fillFailure(result, ErrorMessageEnum.UNKNOWN_EXCEPTION);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加计划时发生未知异常!", e);
            ResultHelper.fillFailure(result, ErrorMessageEnum.UNKNOWN_EXCEPTION);
        }

        return result;
    }

    @Override
    public PlanQueryResult getActivePlans() {
        PlanQueryResult result = new PlanQueryResult();
        List<Plan> planList = planMapper.selectActivePlans();
        result.setPlanList(PlanConvertor.convertToModelList(planList));
        return result;
    }

    @Override
    public BaseServiceResult startPlan(int id) {
        BaseServiceResult result = new BaseServiceResult();
        try {
            Plan plan = planMapper.selectByPrimaryKey(id);
            String unit = plan.getUnit();
            if (StringUtil.equals(unit, PlanUnitEnum.COUNT.getCode())) {
                //先插入一条日程
                BaseServiceResult dailyResult = dailyService.addDaily(plan.getCategory(),
                    TrueFalseEnum.FALSE.getCode(), plan.getContent());
                Assert.isTrue(dailyResult.isSuccess());
                //计数加1
                //                plan.setCurrent(plan.getCurrent() + 1);
                //                planMapper.updateByPrimaryKey(plan);
            } else if (StringUtil.equals(unit, PlanUnitEnum.MINUTE.getCode())) {
                //判断是不是要结束
                if (plan.getDailyId() != 0 && plan.getDailyId() != -1) {
                    int dailyId = plan.getDailyId();
                    plan.setDailyId(-1);
                    planMapper.updateByPrimaryKey(plan);

                    BaseServiceResult endResult = dailyService.endById(dailyId);
                    Assert.isTrue(endResult.isSuccess());

                } else {
                    //先插入一条日程
                    BaseServiceResult dailyResult = dailyService.addDaily(plan.getCategory(),
                        TrueFalseEnum.TRUE.getCode(), plan.getContent());
                    Assert.isTrue(dailyResult.isSuccess());
                    //更新计划
                    Daily daily = new Daily();
                    daily.setContent(plan.getContent());
                    daily.setIsDuration(TrueFalseEnum.TRUE.getCode());
                    daily.setCatagory(plan.getCategory());
                    daily = dailyService.selectByContent(daily);
                    plan.setDailyId(daily.getId());
                    planMapper.updateByPrimaryKey(plan);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("执行计划时发生未知异常!", e);
            ResultHelper.fillFailure(result, ErrorMessageEnum.UNKNOWN_EXCEPTION);
        }
        return result;
    }
}