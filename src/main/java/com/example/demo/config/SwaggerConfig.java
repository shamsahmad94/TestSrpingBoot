package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import com.google.common.collect.Lists;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;

@Configuration
@EnableSwagger2
@EnableWebSecurity
//@EnableOAuth2Sso
//@EnableResourceServer
public class SwaggerConfig extends ResourceServerConfigurerAdapter{
	
	
	public String AuthinticationToken = "oauth 6d9ca027b08bf17ec9e60027050475df85834644";
	
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(regex("/v1.*"))
                .build().apiInfo(metaData())
//                .securitySchemes(Collections.singletonList(apiKey()));
                .securitySchemes(Lists.newArrayList(apiKey()));
//        			.securitySchemes(Arrays.asList((new BasicAuth("test"))));

    }
    
  private ApiInfo metaData() {
  ApiInfo apiInfo = new ApiInfo(
          "Test Shams Ahmed",
          " ",
          "1.0",
          "Terms of service",
          "",
         "",
          "https://www.apache.org/licenses/LICENSE-2.0");
  return apiInfo;
}

  
  public ApiKey apiKey() {
	    return new ApiKey("Authorization", AuthinticationToken, "header");
	}
  
  @Bean
  public SecurityConfiguration security() {

		return new SecurityConfiguration(null, null, null, null, null, ApiKeyVehicle.HEADER, "Authorization", null);
	}
    
}


