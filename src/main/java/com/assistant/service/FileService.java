package com.assistant.service;

import com.assistant.db.model.OneApp;
import com.assistant.models.result.BaseServiceResult;

/**
 * 文件操作服务类.
 * @author hefan.hf
 * @version $Id: FileService, v 0.1 16/4/17 14:02 hefan.hf Exp $
 */
public interface FileService {

    /**
     * 根据url下载ONE图片
     * @param one
     * @return
     */
    BaseServiceResult downloadOnePic(OneApp one);

}