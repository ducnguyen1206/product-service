package com.dav.customerflow.config;

import com.dav.customerflow.data.CustomerFlowData;
import com.dav.customerflow.data.CustomerFlowDataImpl;
import com.dav.customerflow.service.CustomerFlowService;
import com.dav.customerflow.service.impl.CustomerFlowServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerFlowData customerFlowData() {
        return new CustomerFlowDataImpl();
    }

    @Bean
    public CustomerFlowService customerFlowService() {
        return new CustomerFlowServiceImpl(customerFlowData());
    }
}
