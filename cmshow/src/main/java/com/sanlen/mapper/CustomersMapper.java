package com.sanlen.mapper;

import com.sanlen.entity.Customers;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomersMapper {
    /**
     * 删除
     */
    @Delete({
        "delete from customers",
        "where customerNumber = #{customernumber,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer customernumber);

    /**
     * 插入数据
     */
    @Insert({
        "insert into customers (customerNumber, customerName, ",
        "contactLastName, contactFirstName, ",
        "phone, addressLine1, ",
        "addressLine2, city, ",
        "state, postalCode, ",
        "country, salesRepEmployeeNumber, ",
        "creditLimit)",
        "values (#{customernumber,jdbcType=INTEGER}, #{customername,jdbcType=VARCHAR}, ",
        "#{contactlastname,jdbcType=VARCHAR}, #{contactfirstname,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{addressline1,jdbcType=VARCHAR}, ",
        "#{addressline2,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=VARCHAR}, #{postalcode,jdbcType=VARCHAR}, ",
        "#{country,jdbcType=VARCHAR}, #{salesrepemployeenumber,jdbcType=INTEGER}, ",
        "#{creditlimit,jdbcType=DECIMAL})"
    })
    int insert(Customers record);

    /**
     * 新增数据
     */
    int insertSelective(Customers record);

    /**
     */
    @Select({
        "select",
        "customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, ",
        "addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit",
        "from customers",
        "where customerNumber = #{customernumber,jdbcType=INTEGER}"
    })
    //@ResultMap("com.sanlen.mapper.CustomersMapper")
    @ResultType(Customers.class)
    List<Customers> selectByPrimaryKey(Integer customernumber);

    /**
     */
    int updateByPrimaryKeySelective(Customers record);

    /**
     */
    @Update({
        "update customers",
        "set customerName = #{customername,jdbcType=VARCHAR},",
          "contactLastName = #{contactlastname,jdbcType=VARCHAR},",
          "contactFirstName = #{contactfirstname,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "addressLine1 = #{addressline1,jdbcType=VARCHAR},",
          "addressLine2 = #{addressline2,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "postalCode = #{postalcode,jdbcType=VARCHAR},",
          "country = #{country,jdbcType=VARCHAR},",
          "salesRepEmployeeNumber = #{salesrepemployeenumber,jdbcType=INTEGER},",
          "creditLimit = #{creditlimit,jdbcType=DECIMAL}",
        "where customerNumber = #{customernumber,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Customers record);
}