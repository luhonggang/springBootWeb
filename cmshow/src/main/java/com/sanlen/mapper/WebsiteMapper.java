package com.sanlen.mapper;

import com.sanlen.entity.Website;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WebsiteMapper {
    /**
     */
    @Delete({
        "delete from website",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     */
    @Insert({
        "insert into website (id, address, ",
        "client_sysytem, browser_type, ",
        "request_type, view_content, ",
        "total_pv, total_uv, ",
        "view_time, view_count)",
        "values (#{id,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR}, ",
        "#{clientSysytem,jdbcType=VARCHAR}, #{browserType,jdbcType=VARCHAR}, ",
        "#{requestType,jdbcType=VARCHAR}, #{viewContent,jdbcType=VARCHAR}, ",
        "#{totalPv,jdbcType=INTEGER}, #{totalUv,jdbcType=VARCHAR}, ",
        "#{viewTime,jdbcType=TIMESTAMP}, #{viewCount,jdbcType=INTEGER})"
    })
    int insert(Website record);

    /**
     */
    int insertSelective(Website record);

    /**
     */
    @Select({
        "select",
        "id, address, client_sysytem, browser_type, request_type, view_content, total_pv, ",
        "total_uv, view_time, view_count",
        "from website",
        "where id = #{id,jdbcType=INTEGER}"
    })
    //@ResultMap("com.shanlin.carloan.mapper.WebsiteMapper.BaseResultMap")
    @ResultType(Website.class)
    Website selectByPrimaryKey(Integer id);

    /**
     */
    int updateByPrimaryKeySelective(Website record);

    /**
     */
    @Update({
        "update website",
        "set address = #{address,jdbcType=VARCHAR},",
          "client_sysytem = #{clientSysytem,jdbcType=VARCHAR},",
          "browser_type = #{browserType,jdbcType=VARCHAR},",
          "request_type = #{requestType,jdbcType=VARCHAR},",
          "view_content = #{viewContent,jdbcType=VARCHAR},",
          "total_pv = #{totalPv,jdbcType=INTEGER},",
          "total_uv = #{totalUv,jdbcType=VARCHAR},",
          "view_time = #{viewTime,jdbcType=TIMESTAMP},",
          "view_count = #{viewCount,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Website record);

    @Select({
        "SELECT SUM(total_pv) as totalPv,DATE_FORMAT(view_time,\"%Y-%m-%d\") as viewTime,browser_type as browserType FROM website GROUP BY browser_type,view_time"
    })
    @ResultType(Website.class)
    List<Website> queryWebsiteData();

    /**
     *
     * @return
     */
    @Select({
            "SELECT SUM(total_pv) as totalPv,browser_type as browserType FROM website GROUP BY browser_type"
    })
    @ResultType(Website.class)
    List<Website> queryBrowserTotalCounts();

    /**
     *  统计浏览器使用不同的请求方式的总的次数
     * @return
     */
    @Select({
            "SELECT count(*) as viewCount,request_type as requestType ,browser_type as browserType FROM `website` GROUP BY browser_type,request_type"
    })
    @ResultType(Website.class)
    List<Website> queryTotalRequestCounts();

    /**
     * 统计某网站一周内总的浏览量和访问量
     * @return
     */
    @Select({
        "SELECT SUM(total_pv) AS totalPv,SUM(view_count) AS viewCount,view_time AS  viewTime FROM website GROUP BY  view_time"
    })
    @ResultType(Website.class)
    List<Website> queryTotalViewAndCounts();

    @Select({
        "SELECT SUM(total_uv) as totalUv,DATE_FORMAT(view_time,\"%Y-%m-%d\") as viewTime,browser_type as browserType FROM website GROUP BY browser_type,view_time"
    })
    @ResultType(Website.class)
    List<Website> queryTotalUvAndBrowserType();

    @Select({
        "SELECT COUNT(*) as viewCount,browser_type as browserType FROM website  GROUP BY browser_type"
    })
    @ResultType(Website.class)
    List<Website> quesryTotalBrowserCounts();
}