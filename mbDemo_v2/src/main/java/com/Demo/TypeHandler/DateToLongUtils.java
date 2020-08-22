package com.Demo.TypeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.BaseStream;

/**
 * @author nono
 * @Package com.Demo.TypeHandler
 * @ClassName DateToLongUtils.java
 * @Description 自定义继承BaseTypeHandler 将java 类型转换为数据库类型
 * @createTime 2020年08月21日 08:27:00
 */
public class DateToLongUtils extends BaseTypeHandler<Date> {

    //将java类型转换为sql类型
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date date, JdbcType jdbcType) throws SQLException {
       long time =date.getTime();
        ps.setLong(i,time);
    }
    //将sql类型转换为java类型

    /**
     *
     * @param rs 查询出的结果集
     * @param columnName 数据库中转换的字段名称
     * @return
     * @throws SQLException
     */
    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        long time = rs.getLong(4);
        Date date = new Date(time);
        return date;
    }
    //将sql类型转换为java类型
    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long time = rs.getLong(columnIndex);
        Date date = new Date(time);
        return date;
    }
    //将sql类型转换为java类型
    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long time = cs.getLong(columnIndex);
        return new Date(time);
    }

}
