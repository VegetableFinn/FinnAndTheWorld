package com.assistant.service.impl;

import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.assistant.db.model.SaySomething;
import com.assistant.models.enums.ErrorMessageEnum;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.service.SaySomethingService;
import com.assistant.utils.ResultHelper;
import com.assistant.utils.StringUtil;

/**
 * @author hefan.hf
 * @version $Id: SpringMVCInterceptor, v 0.1 16/4/23 17:57 hefan.hf Exp $
 */
public class SpringMVCInterceptor implements HandlerInterceptor {

    private static boolean      isDev = false;

    @Autowired
    private SaySomethingService saySomethingService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (isDev) {
            return true;
        }

        if (httpServletRequest.getSession().getAttribute("user") == null) {

            String loginAccount = "";
            Cookie[] cookies = httpServletRequest.getCookies();//这样便可以获取一个cookie数组
            for (Cookie cookie : cookies) {
                if (StringUtil.equals(cookie.getName(), "user")) {
                    loginAccount = URLDecoder.decode(cookie.getValue(), "utf-8");
                    break;
                }
            }

            SaySomething saySomething = saySomethingService.getSomethingByTrigger(loginAccount);
            if (saySomething != null) {
                httpServletRequest.getSession().setAttribute("user", "user");
                return true;
            }

            Cookie cookie = new Cookie("user", null);
            cookie.setMaxAge(0);
            httpServletResponse.addCookie(cookie);

            httpServletResponse.setContentType("text/x-json;charset=UTF-8");
            httpServletResponse.setHeader("Cache-Control", "no-cache");

            BaseServiceResult result = new BaseServiceResult();
            ResultHelper.fillFailure(result, ErrorMessageEnum.LOGIN_REQUIRED);
            //            httpServletResponse.getOutputStream().write(serialize(result));

            //            JSONObject json = JSON.parseObject(JSON.toJSONString(result));

            //            json.writeJSONString(httpServletResponse.getWriter());
            //                json.write(response.getWriter());
            httpServletResponse.getWriter().write(JSON.toJSONString(result));
            return false;

        }
        return true;
    }

    //    private byte[] serialize(Object obj) throws IOException {
    //        ByteArrayOutputStream out = new ByteArrayOutputStream();
    //        ObjectOutputStream os = new ObjectOutputStream(out);
    //        os.writeObject(obj);
    //        byte[] array = out.toByteArray();
    //        out.close();
    //        os.close();
    //        return array;
    //    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e)
                                                                                               throws Exception {

    }
}