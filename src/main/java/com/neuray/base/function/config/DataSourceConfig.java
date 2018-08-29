package com.neuray.base.function.config;

import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 简介
 * <p>
 * 项目名称:   [base-function]
 * 包:        [com.neuray.base.function.config]
 * 类名称:    [DataSourceConfig]
 * 类描述:    []
 * 创建人:    [于海慧]
 * 创建时间:  [2018/8/30]
 * 修改人:    []
 * 修改时间:  []
 * 修改备注:  []
 * 版本:     [v1.0]
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "dataSource")
    public DataSource dataSource(Environment environment){
        return DataSourceBuilder.create().build();
    }
    @Bean
    public BeetlSqlDataSource beetlSqlDataSource(@Qualifier("dataSource") DataSource dataSource){
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        source.setMasterSource(dataSource);
        return source;
    }
}
