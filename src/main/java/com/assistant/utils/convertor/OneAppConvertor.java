package com.assistant.utils.convertor;

import com.assistant.db.model.OneApp;
import com.assistant.models.core.ContextHolder;
import com.assistant.models.oneApps.OneAppData;

/**
 * @author hefan.hf
 * @version $Id: OneAppConvertor, v 0.1 16/4/16 22:56 hefan.hf Exp $
 */
public class OneAppConvertor {

    /**
     * data转do
     * @return
     */
    public static OneApp toOneApp(OneAppData data) {
        OneApp one = new OneApp();
        one.setGmtModified(ContextHolder.get().getDate());
        one.setAuthor(data.getHp_author());
        one.setContent(data.getHp_content());
        one.setGmtCreate(ContextHolder.get().getDate());
        one.setHpMakettime(data.getHp_makettime());
        one.setImgUrl(data.getIpad_url());
        one.setTitle(data.getHp_title());
        return one;
    }

}