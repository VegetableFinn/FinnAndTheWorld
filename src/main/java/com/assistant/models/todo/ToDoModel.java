package com.assistant.models.todo;

/**
 * @author hefan.hf
 * @version $Id: ToDoModel, v 0.1 16/4/24 22:20 hefan.hf Exp $
 */
public class ToDoModel {
    private Integer id;

    private String  content;

    private String  dt;

    private String  catagory;

    private String  isDone;

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
     * Getter method for property <tt>dt</tt>.
     *
     * @return property value of dt
     */

    public String getDt() {
        return dt;
    }

    /**
     * Setter method for property <tt>dt</tt>.
     *
     * @param dt value to be assigned to property dt
     */
    public void setDt(String dt) {
        this.dt = dt;
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
     * Getter method for property <tt>isDone</tt>.
     *
     * @return property value of isDone
     */

    public String getIsDone() {
        return isDone;
    }

    /**
     * Setter method for property <tt>isDone</tt>.
     *
     * @param isDone value to be assigned to property isDone
     */
    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ToDoModel{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", dt='").append(dt).append('\'');
        sb.append(", catagory='").append(catagory).append('\'');
        sb.append(", isDone='").append(isDone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}