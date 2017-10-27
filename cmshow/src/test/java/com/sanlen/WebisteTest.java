package com.sanlen;

import com.sanlen.common.BrowserUtils;
import com.sanlen.entity.Website;
import com.sanlen.mapper.WebsiteMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author: LuHongGang
 * @time: 2017/10/24
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebisteTest {

    @Autowired
    private WebsiteMapper websiteMapper;

    @Test
    public void websiteInsert(){
        // 构造元数据
        for (int i = 50; i <100 ; i++) {
            Website w = new Website();
            w.setAddress(BrowserUtils.getRandomIp());
            w.setBrowserType("5");
            w.setClientSysytem(i%2==0 ? "Windows" : "AppleWebKit");
            w.setRequestType(i%2== 0 ? "POST" : "GET");
            w.setTotalPv(i);
            w.setTotalUv(i);
            w.setViewContent("页面内容"+i);
            w.setViewCount(20);
            w.setViewTime("2017-10-24");
            websiteMapper.insert(w);
        }
        for (int i = 50; i <100 ; i++) {
            Website w = new Website();
            w.setAddress(BrowserUtils.getRandomIp());
            w.setBrowserType("5");
            w.setClientSysytem(i%2==0 ? "Windows" : "AppleWebKit");
            w.setRequestType(i%2== 0 ? "POST" : "GET");
            w.setTotalPv(i);
            w.setTotalUv(i);
            w.setViewContent("页面内容"+i);
            w.setViewCount(i);
            w.setViewTime("2017-10-25");
            websiteMapper.insert(w);
        }

        for (int i = 100; i <150 ; i++) {
            Website w = new Website();
            w.setAddress(BrowserUtils.getRandomIp());
            w.setBrowserType("5");
            w.setClientSysytem(i%2==0 ? "Windows" : "AppleWebKit");
            w.setRequestType(i%2== 0 ? "POST" : "GET");
            w.setTotalPv(i);
            w.setTotalUv(i);
            w.setViewContent("页面内容"+i);
            w.setViewCount(i);
            w.setViewTime("2017-10-26");
            websiteMapper.insert(w);
        }
        for (int i = 0; i <50 ; i++) {
            Website w = new Website();
            w.setAddress(BrowserUtils.getRandomIp());
            w.setBrowserType("5");
            w.setClientSysytem(i%2==0 ? "Windows" : "AppleWebKit");
            w.setRequestType(i%2== 0 ? "POST" : "GET");
            w.setTotalPv(i);
            w.setTotalUv(i);
            w.setViewContent("页面内容"+i);
            w.setViewCount(23);
            w.setViewTime("2017-10-27");
            websiteMapper.insert(w);
        }
        for (int i = 300; i <350 ; i++) {
            Website w = new Website();
            w.setAddress(BrowserUtils.getRandomIp());
            w.setBrowserType("5");
            w.setClientSysytem(i%2==0 ? "Windows" : "AppleWebKit");
            w.setRequestType(i%2== 0 ? "POST" : "GET");
            w.setTotalPv(i);
            w.setTotalUv(i);
            w.setViewContent("页面内容"+i);
            w.setViewCount(i);
            w.setViewTime("2017-10-28");
            websiteMapper.insert(w);
        }
        for (int i = 0; i <50 ; i++) {
            Website w = new Website();
            w.setAddress(BrowserUtils.getRandomIp());
            w.setBrowserType("5");
            w.setClientSysytem(i%2==0 ? "Windows" : "AppleWebKit");
            w.setRequestType(i%2== 0 ? "POST" : "GET");
            w.setTotalPv(i);
            w.setTotalUv(i);
            w.setViewContent("页面内容"+i);
            w.setViewCount(30);
            w.setViewTime("2017-10-29");
            websiteMapper.insert(w);
        }
        for (int i = 0; i <50 ; i++) {
            Website w = new Website();
            w.setAddress(BrowserUtils.getRandomIp());
            w.setBrowserType("5");
            w.setClientSysytem(i%2==0 ? "Windows" : "AppleWebKit");
            w.setRequestType(i%2== 0 ? "POST" : "GET");
            w.setTotalPv(i);
            w.setTotalUv(i);
            w.setViewContent("页面内容"+i);
            w.setViewCount(80);
            w.setViewTime("2017-10-30");
            websiteMapper.insert(w);
        }
    }

    @Test
    public void websiteListQuery(){
        List<Website> list = websiteMapper.queryWebsiteData();
        for (Website w : list){
            System.out.println("输出的数据是 : "+w.getBrowserType() +" 页面访问量 : "+w.getTotalPv());
        }

        for (int i = 0; i <100 ; i++) {
            Website w = new Website();
            w.setAddress(BrowserUtils.getRandomIp());
            w.setBrowserType("5");
            w.setClientSysytem(i%2==0 ? "Windows" : "AppleWebKit");
            w.setRequestType("GET");
            w.setTotalPv(i);
            w.setTotalUv(i);
            w.setViewContent("页面内容"+i);
            w.setViewCount(80);
            w.setViewTime("2017-10-30");
            websiteMapper.insert(w);
        }
    }
}
