package com.assistant.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistant.db.dao.CommonMapper;
import com.assistant.service.CommonService;
import com.assistant.utils.DateUtil;

/**
 * @author hefan.hf
 * @version $Id: CommonServiceImpl, v 0.1 16/4/16 20:03 hefan.hf Exp $
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonMapper commonMapper;

    @Override
    public Date getSysDate() {
        return DateUtil.convertFromGMTToPRC(commonMapper.getDBDate().getNowDt());
    }
}