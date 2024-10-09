package com.ms.jwt.controller.jwtSecurityConfig;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 


  
@Configuration
public class SwaggerConfig { 
  
	 @Bean
	    public GroupedOpenApi publicApi() {
	        return GroupedOpenApi.builder()
	        		 .group("springshop-public")
	                .pathsToMatch("/Motherson/crm/v1/**")
	                .packagesToScan("com.ms.jwt.controller")
	                .build();
	    }

	    @Bean
	    public GroupedOpenApi adminApi() {
	        return GroupedOpenApi.builder()
	                .group("springshop-admin")
	                .pathsToMatch("/Motherson/crm/v1/**")
	                .packagesToScan("com.ms.jwt.controller")
	                .build();
	    }
}