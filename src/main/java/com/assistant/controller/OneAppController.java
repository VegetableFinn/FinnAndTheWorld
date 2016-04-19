package com.assistant.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("/showOneImage.json")
    @ResponseBody
    public void showImage(HttpServletRequest re, HttpServletResponse response, String title) {

        //        pic_addr = "/Users/hefan/Data/apache-tomcat-7.0.68/webapps/examples/jsp/jsp2/jspx/textRotate.jpg";
        //response.setContentType("text/html; charset=UTF-8");

        String pic_addr = ONE_PIC_PATH + title + ".jpg";

        response.setContentType("image/*");
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            fis = new FileInputStream(pic_addr);
            os = response.getOutputStream();
            int count = 0;
            byte[] buffer = new byte[1024 * 8];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}