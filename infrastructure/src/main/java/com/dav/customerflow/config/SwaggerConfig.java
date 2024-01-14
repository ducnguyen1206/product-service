package com.dav.customerflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

import static com.dav.customerflow.constant.HeaderConstant.REQUEST_JWT;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    private List<RequestParameter> customerRequestHeaders() {
        RequestParameter requestParameter = new RequestParameterBuilder()
                .in(ParameterType.HEADER)
                .name(REQUEST_JWT)
                .required(false)
                .query(param -> param.model(modle -> modle.scalarModel(ScalarType.STRING))).build();
        return List.of(requestParameter);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalRequestParameters(customerRequestHeaders())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dav.customerflow"))
                .paths(PathSelectors.any())
                .build();
    }
}
