package com.sanlen.entity;

import java.util.Date;
/**
 * @author: LuHongGang
 * @time: 2017/10/25
 * @version: 1.0
 */
public class Website {
    /**
     * 
     */
    private Integer id;

    /**
     * IP地址
     */
    private String address;

    /**
     * 客户访问的操作系统
     */
    private String clientSysytem;

    /**
     * 浏览器类型 0-Chrome,1-Mozilla,2-360浏览器,4-Safari
     */
    private String browserType;

    /**
     * 请求类型
     */
    private String requestType;

    /**
     * 访问的内容
     */
    private String viewContent;

    /**
     * 总的页面访问量
     */
    private Integer totalPv;

    /**
     * 用户总访问量
     */
    private Integer totalUv;

    /**
     * 浏览时间
     */
    private String viewTime;

    /**
     * 浏览的次数
     */
    private Integer viewCount;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * IP地址
     * @return address IP地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * IP地址
     * @param address IP地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 客户访问的操作系统
     * @return client_sysytem 客户访问的操作系统
     */
    public String getClientSysytem() {
        return clientSysytem;
    }

    /**
     * 客户访问的操作系统
     * @param clientSysytem 客户访问的操作系统
     */
    public void setClientSysytem(String clientSysytem) {
        this.clientSysytem = clientSysytem == null ? null : clientSysytem.trim();
    }

    /**
     * 浏览器类型 0-Chrome,1-Mozilla,2-360浏览器,4-Safari
     * @return browser_type 浏览器类型 0-Chrome,1-Mozilla,2-360浏览器,4-Safari
     */
    public String getBrowserType() {
        return browserType;
    }

    /**
     * 浏览器类型 0-Chrome,1-Mozilla,2-360浏览器,4-Safari
     * @param browserType 浏览器类型 0-Chrome,1-Mozilla,2-360浏览器,4-Safari
     */
    public void setBrowserType(String browserType) {
        this.browserType = browserType == null ? null : browserType.trim();
    }

    /**
     * 请求类型
     * @return request_type 请求类型
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * 请求类型
     * @param requestType 请求类型
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    /**
     * 访问的内容
     * @return view_content 访问的内容
     */
    public String getViewContent() {
        return viewContent;
    }

    /**
     * 访问的内容
     * @param viewContent 访问的内容
     */
    public void setViewContent(String viewContent) {
        this.viewContent = viewContent == null ? null : viewContent.trim();
    }

    /**
     * 总的页面访问量
     * @return total_pv 总的页面访问量
     */
    public Integer getTotalPv() {
        return totalPv;
    }

    /**
     * 总的页面访问量
     * @param totalPv 总的页面访问量
     */
    public void setTotalPv(Integer totalPv) {
        this.totalPv = totalPv;
    }

    /**
     * 用户总访问量
     * @return total_uv 用户总访问量
     */
    public Integer getTotalUv() {
        return totalUv;
    }

    /**
     * 用户总访问量
     * @param totalUv 用户总访问量
     */
    public void setTotalUv(Integer totalUv) {
        this.totalUv = totalUv == null ? null : totalUv;
    }

    /**
     * 浏览时间
     * @return view_time 浏览时间
     */
    public String getViewTime() {
        return viewTime;
    }

    /**
     * 浏览时间
     * @param viewTime 浏览时间
     */
    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }

    /**
     * 浏览的次数
     * @return view_count 浏览的次数
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * 浏览的次数
     * @param viewCount 浏览的次数
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
}