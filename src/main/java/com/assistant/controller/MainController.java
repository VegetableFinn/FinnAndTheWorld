package com.assistant.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistant.db.model.SaySomething;
import com.assistant.models.enums.ErrorMessageEnum;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.service.SaySomethingService;
import com.assistant.utils.ResultHelper;

/**
 * @author hefan.hf
 * @version $Id: MainController, v 0.1 16/4/14 12:15 hefan.hf Exp $
 */
@Controller
public class MainController extends BaseController {

    @Autowired
    private SaySomethingService saySomethingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //    @RequestMapping("/showInfos")
    //    public @ResponseBody Object showUserInfos() {
    //        List<One> userInfos = oneService.getAll();
    //        return userInfos;
    //    }

    @RequestMapping(value = "/login")
    public @ResponseBody BaseServiceResult login(String loginAccount)
                                                                     throws UnsupportedEncodingException {
        loginAccount = new String(loginAccount.getBytes("ISO-8859-1"), "UTF-8");
        BaseServiceResult result = new BaseServiceResult();
        SaySomething saySomething = saySomethingService.getSomethingByTrigger(loginAccount);
        if (saySomething == null) {
            ResultHelper.fillFailure(result, ErrorMessageEnum.LOGIN_FAIL);
        }
        return result;
    }

}