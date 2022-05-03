package com.hxz.csdn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-05-03-18:40
 * @address 成都
 */
@Component
@ConfigurationProperties(prefix = "hxz.csdn")
public class CsdnVisitsConfig {
    /**
     * CSDN博客个人中心地址
     */
    private String csdnUrl;
    /**
     * 需要刷的文章地址
     */
    private List<String> articleUrl;
    /**
     * 间隔时间
     */
    private Long time;
    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 每页数量
     */
    private Integer size;
    /**
     * 类型
     */
    private String businessType;
    /**
     * 用户名
     */
    private String username;
    /**
     * api地址
     */
    private String apiUrl;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(List<String> articleUrl) {
        this.articleUrl = articleUrl;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getCsdnUrl() {
        return csdnUrl;
    }

    public void setCsdnUrl(String csdnUrl) {
        this.csdnUrl = csdnUrl;
    }

    @Override
    public String toString() {
        return "CsdnVisitsConfig{" +
                "csdnUrl='" + csdnUrl + '\'' +
                ", articleUrl=" + articleUrl.toString() +
                ", time=" + time +
                '}';
    }
}
