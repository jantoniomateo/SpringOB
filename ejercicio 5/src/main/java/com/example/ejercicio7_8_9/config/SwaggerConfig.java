package com.example.ejercicio7_8_9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuración de Swagger para Json.
 */
@Configuration
public class SwaggerConfig {

@Bean
    public Docket apiDocket(){

    return new Docket(DocumentationType.SWAGGER_2)  //indicamos que vamos a utilizar la versión 2 de swagger.
            .apiInfo(apiDetail())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
}

    private ApiInfo apiDetail(){
    return new ApiInfo("Spring Boot Book API REST",
            "Biblioteca de documentos API REST",
            "1.0",
            "http://www.elmejor.com",
            new Contact("jmateo", "http://www.elmejor.com", "elmejor@elmejor.com"),
            "MIT",
            "http://www.elmejor.com",
            Collections.emptyList());
}

}
