package com.assistant.models.daily;

/**
 * @author hefan.hf
 * @version $Id: DailyModel, v 0.1 16/4/22 18:30 hefan.hf Exp $
 */
public class DailyModel {
    private Integer id;

    private String  content;

    private String  startDt;

    private String  endDt;

    private Boolean isDuration;

    private String  catagory;

    private String  durationDt;

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */

    public Integer getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>content</tt>.
     *
     * @return property value of content
     */

    public String getContent() {
        return content;
    }

    /**
     * Setter method for property <tt>content</tt>.
     *
     * @param content value to be assigned to property content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter method for property <tt>startDt</tt>.
     *
     * @return property value of startDt
     */

    public String getStartDt() {
        return startDt;
    }

    /**
     * Setter method for property <tt>startDt</tt>.
     *
     * @param startDt value to be assigned to property startDt
     */
    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    /**
     * Getter method for property <tt>endDt</tt>.
     *
     * @return property value of endDt
     */

    public String getEndDt() {
        return endDt;
    }

    /**
     * Setter method for property <tt>endDt</tt>.
     *
     * @param endDt value to be assigned to property endDt
     */
    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    /**
     * Getter method for property <tt>isDuration</tt>.
     *
     * @return property value of isDuration
     */

    public Boolean getDuration() {
        return isDuration;
    }

    /**
     * Setter method for property <tt>setDuration</tt>.
     *
     * @param duration value to be assigned to property isDuration
     */
    public void setDuration(Boolean duration) {
        isDuration = duration;
    }

    /**
     * Getter method for property <tt>catagory</tt>.
     *
     * @return property value of catagory
     */

    public String getCatagory() {
        return catagory;
    }

    /**
     * Setter method for property <tt>catagory</tt>.
     *
     * @param catagory value to be assigned to property catagory
     */
    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    /**
     * Getter method for property <tt>durationDt</tt>.
     *
     * @return property value of durationDt
     */

    public String getDurationDt() {
        return durationDt;
    }

    /**
     * Setter method for property <tt>durationDt</tt>.
     *
     * @param durationDt value to be assigned to property durationDt
     */
    public void setDurationDt(String durationDt) {
        this.durationDt = durationDt;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DailyModel{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", startDt='").append(startDt).append('\'');
        sb.append(", endDt='").append(endDt).append('\'');
        sb.append(", isDuration=").append(isDuration);
        sb.append(", catagory='").append(catagory).append('\'');
        sb.append(", durationDt='").append(durationDt).append('\'');
        sb.append('}');
        return sb.toString();
    }
}