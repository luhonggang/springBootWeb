package com.sanlen;

import com.alibaba.fastjson.JSONObject;
import com.sanlen.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LuHongGang
 * @time: 2017/10/25
 * @version: 1.0
 */
@RestController
public class WebsiteController {

    @Autowired
    private WebsiteService websiteService;

    /**
     * 折线图数据  标准面积图
     * @return
     */
    @RequestMapping(value="/queryLinesForWebsite",method = RequestMethod.POST)
    public JSONObject areaForWebsite(){
        return  websiteService.loadingLinesData();
    }

    /**
     * 饼图数据  标准饼图
     * queryPieForWebsite
     * @return
     */
    @RequestMapping(value="/queryPieForWebsite",method = RequestMethod.POST)
    public JSONObject pieForWebsite(){
        return websiteService.loadingPieData();
    }

    /**
     * 雷达图数据 标准填充雷达
     * @return
     */
    @RequestMapping(value="/queryRadarForWebsite",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject queryRadarForWebsite(){
        return websiteService.queryRadarForWebsite();
    }

    /**
     * 折线图  柱状图
     * @return
     */
    @RequestMapping(value="/loadLineBarForChart",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject loadLineBarForChart(){
        return websiteService.queryLineBarForWebsite();
    }

    /**
     * 折线图数据  堆积面积图
     * @return
     */
    @RequestMapping(value="/queryAreaForWebsite",method = RequestMethod.POST)
    public JSONObject queryAreaForWebsite(){
        return  websiteService.queryAreaForWebsite();
    }

    /**
     * 折线图数据  堆积面积图
     * @return
     */
    @RequestMapping(value="/querySquareChart",method = RequestMethod.POST)
    public JSONObject querySquareChart(){
        return  websiteService.querySquareForWebsite();
    }


    /**
     * 条形图数据  鲜明对比图数据
     * @return
     */
    @RequestMapping(value="/queryTiaoXingChart",method = RequestMethod.POST)
    public JSONObject queryTiaoXingChart(){
        return  websiteService.queryTiaoXingChart();
    }


}
