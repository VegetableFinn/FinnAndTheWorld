package com.assistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistant.service.CommonService;
import com.assistant.service.OneAppService;

/**
 * @author hefan.hf
 * @version $Id: OneAppController, v 0.1 16/4/16 19:14 hefan.hf Exp $
 */
@Controller
@RequestMapping("/one")
public class OneAppController extends BaseController {

    @Autowired
    private OneAppService oneAppService;

    @Autowired
    private CommonService commonService;

    @RequestMapping("/getAll")
    public String showUserInfos() {
        return "index";
    }

    //    @RequestMapping("/downloadHistoryPics")
    //    public @ResponseBody Object downloadHistoryPics() {
    //        return oneAppService.downloadHistoryPics();
    //    }
    //
    //    @RequestMapping("/checkForNewOne")
    //    public @ResponseBody Object checkForNewOne() {
    //        return oneAppService.checkForNewOne();
    //    }

    @RequestMapping("/getLastOne.json")
    public @ResponseBody Object getLastOne() {
        return oneAppService.selectLastOne();
    }

}