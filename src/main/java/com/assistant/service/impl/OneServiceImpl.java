package com.assistant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistant.db.dao.OneMapper;
import com.assistant.db.model.One;
import com.assistant.service.OneService;

/**
 * @author hefan.hf
 * @version $Id: OneServiceImpl, v 0.1 16/4/16 17:02 hefan.hf Exp $
 */
@Service("oneService")
public class OneServiceImpl implements OneService {

    /** Mapper */
    @Autowired
    private OneMapper oneMapper;

    public List<One> getAll() {
        return oneMapper.selectAll();
    }
}