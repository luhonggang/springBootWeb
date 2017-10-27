package com.sanlen.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: LuHongGang
 * @time: 2017/10/24
 * @version: 1.0
 */
public interface WebsiteService {
    JSONObject loadingLinesData();

    JSONObject loadingPieData();

    JSONObject queryRadarForWebsite();

    JSONObject queryLineBarForWebsite();

    JSONObject queryAreaForWebsite();

    JSONObject querySquareForWebsite();

    JSONObject queryTiaoXingChart();
}
