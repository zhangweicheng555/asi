package com.boot.kaizen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicates;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger文档
 * 
 * @author weichengz
 * @date 2018年9月1日 上午8:16:50
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket() {

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("接口文档说明").apiInfo(new ApiInfoBuilder().title("接口文档")
						.contact(new Contact("Kaizen管理系统", "", "19348243@qq.com")).version("1.0").build())
				.select().paths(Predicates.or(PathSelectors.regex("/zwc")//
						, PathSelectors.regex("/zwp")//
						, PathSelectors.regex("/auto/check/.*")))// 这个.*注意 这个重要
				.build();
	}
}
