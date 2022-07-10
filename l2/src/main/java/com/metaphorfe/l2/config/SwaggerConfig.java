package com.metaphorfe.l2.config;

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
@EnableSwagger2
public class SwaggerConfig { 
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.metaphorfe.l2.controller"))
          .paths(PathSelectors.any())
          .build().apiInfo(apiInfo());
    }
    	
    private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("JCaballero")
				.description("Prueba Tecnica MetaPhorce")
				.termsOfServiceUrl("Juan Caballero")
				.licenseUrl("Juan Caballero")
				.version("1.0")
				.build();
	}
    
}