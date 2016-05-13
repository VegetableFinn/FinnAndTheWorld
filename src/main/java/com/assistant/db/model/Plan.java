package com.assistant.db.model;

import java.util.Date;

public class Plan {
    private Integer id;

    private String  content;

    private Integer total;

    private Integer current;

    private String  unit;

    private Date    gmtCreate;

    private Date    gmtModified;

    private String  isFinished;

    private Date    startDt;

    private Date    endDt;

    private int     dailyId;

    private String  category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished == null ? null : isFinished.trim();
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    /**
     * Getter method for property <tt>dailyId</tt>.
     *
     * @return property value of dailyId
     */

    public int getDailyId() {
        return dailyId;
    }

    /**
     * Setter method for property <tt>dailyId</tt>.
     *
     * @param dailyId value to be assigned to property dailyId
     */
    public void setDailyId(int dailyId) {
        this.dailyId = dailyId;
    }

    /**
     * Getter method for property <tt>category</tt>.
     *
     * @return property value of category
     */

    public String getCategory() {
        return category;
    }

    /**
     * Setter method for property <tt>category</tt>.
     *
     * @param category value to be assigned to property category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}