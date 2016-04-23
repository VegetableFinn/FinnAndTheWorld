package com.assistant.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.assistant.models.enums.ErrorMessageEnum;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.utils.ResultHelper;

/**
 * @author hefan.hf
 * @version $Id: SpringMVCInterceptor, v 0.1 16/4/23 17:57 hefan.hf Exp $
 */
public class SpringMVCInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (httpServletRequest.getSession().getAttribute("user") == null) {
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