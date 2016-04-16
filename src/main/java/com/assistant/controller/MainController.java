package com.assistant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistant.db.model.One;
import com.assistant.service.OneService;

/**
 * @author hefan.hf
 * @version $Id: MainController, v 0.1 16/4/14 12:15 hefan.hf Exp $
 */
@Controller
public class MainController {

    @Autowired
    private OneService oneService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping("/showInfos")
    public @ResponseBody Object showUserInfos() {
        List<One> userInfos = oneService.getAll();
        return userInfos;
    }
}