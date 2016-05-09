package com.assistant.models.plan;

/**
 * @author hefan.hf
 * @version $Id: PlanModel, v 0.1 16/5/9 12:26 hefan.hf Exp $
 */
public class PlanModel {

    private Integer id;

    private String  content;

    private Boolean isFinished;

    private String  startDt;

    private String  endDt;

    private String  progress;

    private String  percent;

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
     * Getter method for property <tt>isFinished</tt>.
     *
     * @return property value of isFinished
     */

    public Boolean getFinished() {
        return isFinished;
    }

    /**
     * Setter method for property <tt>isFinished</tt>.
     *
     * @param isFinished value to be assigned to property isFinished
     */
    public void setFinished(Boolean finished) {
        isFinished = finished;
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
     * Getter method for property <tt>progress</tt>.
     *
     * @return property value of progress
     */

    public String getProgress() {
        return progress;
    }

    /**
     * Setter method for property <tt>progress</tt>.
     *
     * @param progress value to be assigned to property progress
     */
    public void setProgress(String progress) {
        this.progress = progress;
    }

    /**
     * Getter method for property <tt>percent</tt>.
     *
     * @return property value of percent
     */

    public String getPercent() {
        return percent;
    }

    /**
     * Setter method for property <tt>percent</tt>.
     *
     * @param percent value to be assigned to property percent
     */
    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PlanModel{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", isFinished=").append(isFinished);
        sb.append(", startDt='").append(startDt).append('\'');
        sb.append(", endDt='").append(endDt).append('\'');
        sb.append(", progress='").append(progress).append('\'');
        sb.append(", percent='").append(percent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}