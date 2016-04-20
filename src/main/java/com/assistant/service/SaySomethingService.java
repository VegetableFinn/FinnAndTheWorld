package com.assistant.service;

import com.assistant.db.model.SaySomething;

/**
 * @author hefan.hf
 * @version $Id: SaySomethingService, v 0.1 16/4/20 21:33 hefan.hf Exp $
 */
public interface SaySomethingService {

    SaySomething getSomethingByTrigger(String trigger);

}