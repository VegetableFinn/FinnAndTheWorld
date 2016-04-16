package com.assistant.models.oneApps;

import java.util.List;

/**
 * @author hefan.hf
 * @version $Id: OneAppJson, v 0.1 16/4/16 22:42 hefan.hf Exp $
 */
public class OneAppJson {
    private String           res;
    private List<OneAppData> data;

    /**
     * Getter method for property <tt>res</tt>.
     *
     * @return property value of res
     */

    public String getRes() {
        return res;
    }

    /**
     * Setter method for property <tt>res</tt>.
     *
     * @param res value to be assigned to property res
     */
    public void setRes(String res) {
        this.res = res;
    }

    /**
     * Getter method for property <tt>data</tt>.
     *
     * @return property value of data
     */

    public List<OneAppData> getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     *
     * @param data value to be assigned to property data
     */
    public void setData(List<OneAppData> data) {
        this.data = data;
    }
}