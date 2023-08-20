package com.picpaysimplificado.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI () {
        return new OpenAPI().info(new Info()
            .title("Simplified Picpay")
            .version("v1")
            .description("Picpay Transaction Rest API Challenge")
            .license(
                new License()
                    .name("Picpay Challenge")
                    .url("https://github.com/PicPay/picpay-desafio-backend")));
    }
}
