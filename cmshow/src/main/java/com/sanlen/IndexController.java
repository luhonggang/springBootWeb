package com.sanlen;

import com.sanlen.entity.Person;
import com.sanlen.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 页面路由
 * @Author: LuHongGang
 * @Date: 2017/10/24
 * @Version: 1.0
 */
@RestController
public class IndexController {

    /**
     * 首页展示
     * @return
     */
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value="/linesChart",method = RequestMethod.GET)
    public ModelAndView hello() {
        return new ModelAndView("linesChart");
    }

    @RequestMapping(value="/piepage",method = RequestMethod.GET)
    public ModelAndView piePage(){
        return new ModelAndView("pieChart");
    }

    @RequestMapping(value="/radarChart",method = RequestMethod.GET)
    public ModelAndView radarChart(){
        return new ModelAndView("radarChart");
    }

    @RequestMapping(value="/areaChart",method = RequestMethod.GET)
    public ModelAndView areaChart(){
        return new ModelAndView("areaChart");
    }

    @RequestMapping(value="/mapChart",method = RequestMethod.GET)
    public ModelAndView visit5(){
        return new ModelAndView("mapChart");
    }

    @RequestMapping(value="/lineBarChart",method = RequestMethod.GET)
    public ModelAndView lineBarChart(){
        return new ModelAndView("lineBarChart");
    }

    @RequestMapping(value="/markTimeLine",method = RequestMethod.GET)
    public ModelAndView markTimeLine(){
        return new ModelAndView("markTimeLine");}

    @RequestMapping(value="/squareChart",method = RequestMethod.GET)
    public ModelAndView squareChart(){
        return new ModelAndView("squareChart");
    }

    @RequestMapping(value="/circleChart",method = RequestMethod.GET)
    public ModelAndView circleChart(){
        return new ModelAndView("circleChart");
    }

}
