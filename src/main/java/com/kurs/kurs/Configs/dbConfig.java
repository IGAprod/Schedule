package com.kurs.kurs.Configs;

import org.springframework.context.annotation.Configuration;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan("com.kurs.kurs")
public class dbConfig {
    @Resource
    private Environment env;

    /*@Bean
    public DataSource dataSource(){

        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(env.getRequiredProperty("db.url"));
        ds.setDriverClassName(env.getRequiredProperty("db.driver"));
        ds.setUsername(env.getRequiredProperty("db.username"));
        ds.setPassword(env.getRequiredProperty("db.password"));

        return ds;
    }*/

}
