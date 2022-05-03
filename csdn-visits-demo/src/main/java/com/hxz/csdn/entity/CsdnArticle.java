package com.hxz.csdn.entity;

import java.io.Serializable;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-05-03-19:44
 * @address 成都
 */
public class CsdnArticle implements Serializable {
    private Long articleId;
    private String title;
    private String description;
    private String url;
    private Integer type;
    private Boolean top;
    private Boolean forcePlan;
    private Long viewCount;
    private Long commentCount;
    private String editUrl;
    private String postTime;
    private Integer diggCount;
    private String formatTime;

    @Override
    public String toString() {
        return "CsdnArticle{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", top=" + top +
                ", forcePlan=" + forcePlan +
                ", viewCount=" + viewCount +
                ", commentCount=" + commentCount +
                ", editUrl='" + editUrl + '\'' +
                ", postTime='" + postTime + '\'' +
                ", diggCount=" + diggCount +
                ", formatTime='" + formatTime + '\'' +
                '}';
    }

    public CsdnArticle() {
    }

    public CsdnArticle(Long articleId, String title, String description, String url, Integer type, Boolean top, Boolean forcePlan, Long viewCount, Long commentCount, String editUrl, String postTime, Integer diggCount, String formatTime) {
        this.articleId = articleId;
        this.title = title;
        this.description = description;
        this.url = url;
        this.type = type;
        this.top = top;
        this.forcePlan = forcePlan;
        this.viewCount = viewCount;
        this.commentCount = commentCount;
        this.editUrl = editUrl;
        this.postTime = postTime;
        this.diggCount = diggCount;
        this.formatTime = formatTime;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Boolean getForcePlan() {
        return forcePlan;
    }

    public void setForcePlan(Boolean forcePlan) {
        this.forcePlan = forcePlan;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public String getEditUrl() {
        return editUrl;
    }

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Integer getDiggCount() {
        return diggCount;
    }

    public void setDiggCount(Integer diggCount) {
        this.diggCount = diggCount;
    }

    public String getFormatTime() {
        return formatTime;
    }

    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
    }
}
