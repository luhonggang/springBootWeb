package com.sanlen.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sanlen.entity.Website;
import com.sanlen.mapper.WebsiteMapper;
import com.sanlen.service.WebsiteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: LuHongGang
 * @time: 2017/10/24
 * @version: 1.0
 */
@Service
@Transactional
public class WebsiteServiceImpl implements WebsiteService {

    private static final Logger logger = LogManager.getLogger(WebsiteServiceImpl.class);

    @Autowired
    private WebsiteMapper websiteMapper;

    /**
     *  折线图 之 标准面积图数据构造
     *  统计不同浏览器 在不同时间下的访问量的情况
     *  @return  JSONObject
     */
    @Override
    public JSONObject loadingLinesData() {
        JSONObject obj = new JSONObject();
        List<String> dateArray = Arrays.asList("2017-10-24","2017-10-25","2017-10-26","2017-10-27","2017-10-28","2017-10-29","2017-10-30");
        //浏览器类型 0-Chrome,1-Mozilla,2-360Browser,3-QQBrowser,4-Safari,5-Opera
        List<Website> list = websiteMapper.queryWebsiteData();
        JSONArray a1 = new JSONArray();
        JSONArray a2 = new JSONArray();
        JSONArray a3 = new JSONArray();
        JSONArray a4 = new JSONArray();
        JSONArray a5 = new JSONArray();
        JSONArray a6 = new JSONArray();
        if(list.size() != 0){
           for (Website w : list){
               if("0".equals(w.getBrowserType())){
                   a1.add(w.getTotalPv());
               }else if("1".equals(w.getBrowserType())){
                   a2.add(w.getTotalPv());
               }else if("2".equals(w.getBrowserType())){
                   a3.add(w.getTotalPv());
               }else if("3".equals(w.getBrowserType())){
                   a4.add(w.getTotalPv());
               }else if("4".equals(w.getBrowserType())){
                   a5.add(w.getTotalPv());
               }else {
                   a6.add(w.getTotalPv());
               }
           }
        }else{
            System.out.println("数据为空");
        }
        //浏览器类型 0-Chrome,1-Mozilla,2-360Browser,3-QQBrowser,4-Safari,5-Opera
        List<String> browserType = Arrays.asList("Chrome","Mozilla","360Browser","QQBrowser","Safari","Opera");
        obj.put("a1",a1);
        obj.put("a2",a2);
        obj.put("a3",a3);
        obj.put("a4",a4);
        obj.put("a5",a5);
        obj.put("a6",a6);
        obj.put("dateArray",dateArray);
        obj.put("type",browserType);
        return obj;
    }

    /**
     * 饼图数据 之 标准饼图数据构造
     * 统计:使用不同浏览器的访问总量占比
     * @return
     */
    @Override
    public JSONObject loadingPieData() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        //浏览器类型 0-Chrome,1-Mozilla,2-360Browser,3-QQBrowser,4-Safari,5-Opera
        List<Website> list = websiteMapper.queryBrowserTotalCounts();
        /**
         *  饼图数据模型:
         *  data:[
                 {value:335, name:'直接访问'},
                 {value:310, name:'邮件营销'},
                 {value:234, name:'联盟广告'},
                 {value:135, name:'视频广告'},
                 {value:1548, name:'搜索引擎'}
                 ]
         */
       if(list.size() != 0){
           for (Website w:list) {
               if("0".equals(w.getBrowserType())){
                   JSONObject b1 = new JSONObject();
                   b1.put("value",w.getTotalPv());
                   b1.put("name","Chrome");
                   array.add(b1);
               }else if("1".equals(w.getBrowserType())){
                   JSONObject b1 = new JSONObject();
                   b1.put("value",w.getTotalPv());
                   b1.put("name","Mozilla");
                   array.add(b1);
               }else if("2".equals(w.getBrowserType())){
                   JSONObject b1 = new JSONObject();
                   b1.put("value",w.getTotalPv());
                   b1.put("name","360Browser");
                   array.add(b1);
               }else if("3".equals(w.getBrowserType())){
                   JSONObject b1 = new JSONObject();
                   b1.put("value",w.getTotalPv());
                   b1.put("name","QQBrowser");
                   array.add(b1);
               }else if("4".equals(w.getBrowserType())){
                   JSONObject b1 = new JSONObject();
                   b1.put("value",w.getTotalPv());
                   b1.put("name","Safari");
                   array.add(b1);
               }else {
                   JSONObject b1 = new JSONObject();
                   b1.put("value",w.getTotalPv());
                   b1.put("name","Opera");
                   array.add(b1);
               }

           }
       }else{
           System.out.println("<<<<<----------------后端打印 ------------>>>>> : 查询的数据为空");
       }
        List<String> browserType = Arrays.asList("Chrome","Mozilla","360Browser","QQBrowser","Safari","Opera");
        obj.put("browserType",browserType);

        obj.put("data",array);
        return obj;
    }

    /**
     * 雷达图 之 标准雷达填充图
     *  统计的是 不同浏览器使用(POST或GET请求方式)浏览 使用请求方式次数的总占比
     * @return
     */
    @Override
    public JSONObject queryRadarForWebsite() {
        int type = 6;
        JSONObject obj  = new JSONObject();
        List<Website> listWbs = websiteMapper.queryTotalRequestCounts();
        JSONArray post = new JSONArray();
        JSONArray get = new JSONArray();
        JSONObject po = new JSONObject();
        JSONObject go = new JSONObject();
        JSONArray resultArray = new JSONArray();
        if(listWbs.size() !=0){
            for (Website w:listWbs) {
                if("POST".equals(w.getRequestType())){
                    post.add(w.getViewCount());
                }else {
                    get.add(w.getViewCount());
                }
            }
        }else {
            for (int i = 0; i <type ; i++) {
                post.add(new Random().nextInt(1000));
                get.add(new Random().nextInt(1000));
            }
        }

        po.put("name","POST");
        po.put("value",post);
        resultArray.add(po);
        go.put("name","GET");
        go.put("value",get);
        resultArray.add(go);
        obj.put("result",resultArray);
        return obj;
    }

    /**
     * 统计不同某个网站的一周的浏览量和访问量
     * @return
     */
    @Override
    public JSONObject queryLineBarForWebsite() {
        JSONObject obj = new JSONObject();

        List<Website> toalViewsCounts = websiteMapper.queryTotalViewAndCounts();
        JSONArray dateArray = new JSONArray();
        JSONArray totalPv = new JSONArray();
        JSONArray totalCounts = new JSONArray();
        if(toalViewsCounts.size() != 0){
            for(Website website : toalViewsCounts){
                dateArray.add(website.getViewTime());
                totalPv.add(website.getTotalPv());
                totalCounts.add(website.getViewCount());
            }
        }
        obj.put("dateArray",dateArray);
        obj.put("totalPv",totalPv);
        obj.put("totalCounts",totalCounts);
        return obj;
    }

    /**
     * 堆积面积图 统计使用 不同浏览器的中用户访问量
     * @return
     */
    @Override
    public JSONObject queryAreaForWebsite() {
        JSONObject obj = new JSONObject();
        List<String> dateArray = Arrays.asList("2017-10-24","2017-10-25","2017-10-26","2017-10-27","2017-10-28","2017-10-29","2017-10-30");
        //浏览器类型 0-Chrome,1-Mozilla,2-360Browser,3-QQBrowser,4-Safari,5-Opera
        List<Website> list = websiteMapper.queryTotalUvAndBrowserType();
        JSONArray a1 = new JSONArray();
        JSONArray a2 = new JSONArray();
        JSONArray a3 = new JSONArray();
        JSONArray a4 = new JSONArray();
        JSONArray a5 = new JSONArray();
        JSONArray a6 = new JSONArray();
        if(list.size() != 0){
            for (Website w : list){
                if("0".equals(w.getBrowserType())){
                    a1.add(w.getTotalUv());
                }else if("1".equals(w.getBrowserType())){
                    a2.add(w.getTotalUv());
                }else if("2".equals(w.getBrowserType())){
                    a3.add(w.getTotalUv());
                }else if("3".equals(w.getBrowserType())){
                    a4.add(w.getTotalUv());
                }else if("4".equals(w.getBrowserType())){
                    a5.add(w.getTotalUv());
                }else {
                    a6.add(w.getTotalUv());
                }
            }
        }else{
            System.out.println("数据为空");
        }
        //浏览器类型 0-Chrome,1-Mozilla,2-360Browser,3-QQBrowser,4-Safari,5-Opera
        List<String> browserType = Arrays.asList("Chrome","Mozilla","360Browser","QQBrowser","Safari","Opera");
        obj.put("a1",a1);
        obj.put("a2",a2);
        obj.put("a3",a3);
        obj.put("a4",a4);
        obj.put("a5",a5);
        obj.put("a6",a6);
        obj.put("dateArray",dateArray);
        obj.put("browserType",browserType);
        return obj;
    }

    /**
     * 统计不同浏览器的使用占比
     * @return
     */
    @Override
    public JSONObject querySquareForWebsite() {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        List<Website> listWebsites = websiteMapper.quesryTotalBrowserCounts();
        if(listWebsites.size() != 0){
            for (int i = 0; i <listWebsites.size() ; i++) {
                Website w = listWebsites.get(i);
                JSONObject web = new JSONObject();
                if("0".equals(w.getBrowserType())){
                    web.put("value",w.getViewCount());
                    web.put("name","Chrome");
                    array.add(web);
                }else if("1".equals(w.getBrowserType())){
                    web.put("value",w.getViewCount());
                    web.put("name","Mozilla");
                    array.add(web);
                }else if("2".equals(w.getBrowserType())){
                    web.put("value",w.getViewCount());
                    web.put("name","360Browser");
                    array.add(web);
                }else if("3".equals(w.getBrowserType())){
                    web.put("value",w.getViewCount());
                    web.put("name","QQBrowser");
                    array.add(web);
                }else if("4".equals(w.getBrowserType())){
                    web.put("value",w.getViewCount());
                    web.put("name","Safari");
                    array.add(web);
                }else {
                    web.put("value",w.getViewCount());
                    web.put("name","Opera");
                    array.add(web);
                }
            }
        }
        obj.put("dataArray",array);
        return obj;
    }

    /**
     *  鲜明的对比图
     *  @return
     */
    @Override
    public JSONObject queryTiaoXingChart() {
        JSONObject obj = new JSONObject();
        List<Website> list = websiteMapper.queryWebsiteData();
        JSONArray a1 = new JSONArray();
        JSONArray a2 = new JSONArray();
        JSONArray a3 = new JSONArray();
        JSONArray a4 = new JSONArray();
        JSONArray a5 = new JSONArray();
        JSONArray a6 = new JSONArray();
        if(list.size() != 0){
            for (Website w : list){
                if("0".equals(w.getBrowserType())){
                    a1.add(w.getTotalPv());
                }else if("1".equals(w.getBrowserType())){
                    a2.add(w.getTotalPv());
                }else if("2".equals(w.getBrowserType())){
                    a3.add(w.getTotalPv());
                }else if("3".equals(w.getBrowserType())){
                    a4.add(w.getTotalPv());
                }else if("4".equals(w.getBrowserType())){
                    a5.add(w.getTotalPv());
                }else {
                    a6.add(w.getTotalPv());
                }
            }
        }else{
            System.out.println("数据为空");
        }
        //浏览器类型 0-Chrome,1-Mozilla,2-360Browser,3-QQBrowser,4-Safari,5-Opera
        List<String> browserType = Arrays.asList("Chrome","Mozilla","360Browser","QQBrowser","Safari","Opera");
        obj.put("a1",a1);
        obj.put("a2",a2);
        obj.put("a3",a3);
        obj.put("a4",a4);
        obj.put("a5",a5);
        obj.put("a6",a6);
        obj.put("type",browserType);
        return obj;
    }
}
