package com.gk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2//For Enabling Swagger
public class BookConfig {

	/**
	 * A builder which is intended to be the primary interface into the Springfox framework.
	 * Provides sensible defaults and convenience methods for configuration.
	 */
	//Docket class to inform swagger that we require documentation of type 2 
	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("GK Software Solutions")
				.select()
				.paths(PathSelectors.ant("/book/**"))//url for which controller we require documentation
				.apis(RequestHandlerSelectors.basePackage("com.gk"))
				.build()
				.apiInfo(apiInfo());
	}

	
	private ApiInfo apiInfo() {
		/**
		 * Builds the api information
		 */
		return new ApiInfoBuilder().title("Book Resource")
				.description("Sample Documentation Generateed Using SWAGGER2 for our Book Rest API")
				.termsOfServiceUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
				.license("Java_Gyan_Mantra License")
				.licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ").version("1.1.0").build();
	}
}
