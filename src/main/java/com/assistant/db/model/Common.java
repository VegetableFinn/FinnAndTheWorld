package com.assistant.db.model;

import java.util.Date;

/**
 * @author hefan.hf
 * @version $Id: Common, v 0.1 16/4/16 19:59 hefan.hf Exp $
 */
public class Common {

    private Date nowDt;

    /**
     * Getter method for property <tt>nowDt</tt>.
     *
     * @return property value of nowDt
     */

    public Date getNowDt() {
        return nowDt;
    }

    /**
     * Setter method for property <tt>nowDt</tt>.
     *
     * @param nowDt value to be assigned to property nowDt
     */
    public void setNowDt(Date nowDt) {
        this.nowDt = nowDt;
    }
}