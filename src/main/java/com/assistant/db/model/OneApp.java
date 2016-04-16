package com.assistant.db.model;

import java.util.Date;

public class OneApp {
    private Integer id;

    private String  title;

    private String  imgUrl;

    private String  author;

    private String  hpMakettime;

    private Date    gmtCreate;

    private Date    gmtModified;

    private String  content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getHpMakettime() {
        return hpMakettime;
    }

    public void setHpMakettime(String hpMakettime) {
        this.hpMakettime = hpMakettime == null ? null : hpMakettime.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OneApp{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", hpMakettime='").append(hpMakettime).append('\'');
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}