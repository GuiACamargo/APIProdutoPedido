package com.atitus.APIProdutoPedido.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Documentação Sistema de Produto e Pedido")
                        .description("API para Produto e Pedido")
                        .contact(new Contact().name("Desenvolvedor").email("devproduto@atitus.edu.br"))
                        .version("Versão 01"));
    }
}
