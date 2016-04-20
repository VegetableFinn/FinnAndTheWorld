package com.assistant.db.model;

import java.util.Date;

public class SaySomething {
    private Integer id;

    private String triggerRegex;

    private Date gmtCreate;

    private Date gmtModified;

    private String enable;

    private String effects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTriggerRegex() {
        return triggerRegex;
    }

    public void setTriggerRegex(String triggerRegex) {
        this.triggerRegex = triggerRegex == null ? null : triggerRegex.trim();
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

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects == null ? null : effects.trim();
    }
}