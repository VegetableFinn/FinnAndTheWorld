package com.assistant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistant.db.dao.SaySomethingMapper;
import com.assistant.db.model.SaySomething;
import com.assistant.service.SaySomethingService;

/**
 * @author hefan.hf
 * @version $Id: SaySomethingServiceImpl, v 0.1 16/4/20 21:38 hefan.hf Exp $
 */
@Service("saySomethingService")
public class SaySomethingServiceImpl extends BaseService implements SaySomethingService {

    /** DAO对象 */
    @Autowired
    private SaySomethingMapper saySomethingMapper;

    @Override
    public SaySomething getSomethingByTrigger(String trigger) {
        SaySomething saySomething = saySomethingMapper.selectByTrigger(trigger);
        return saySomething;
    }
}