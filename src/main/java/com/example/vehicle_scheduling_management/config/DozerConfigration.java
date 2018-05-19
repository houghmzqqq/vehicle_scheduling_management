package com.example.vehicle_scheduling_management.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.dozer.Mapper;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/13.
 */
@Configuration
public class DozerConfigration {

    @Bean(name = "org.dozer.Mapper")
    @Scope("prototype")
    public DozerBeanMapper dozerBean(){
        List<String> mappingFiles = Arrays.asList("dozerBeanMapping.xml");
        DozerBeanMapper dozerBean = new DozerBeanMapper();
        dozerBean.setMappingFiles(mappingFiles);

        return dozerBean;
    }
}
