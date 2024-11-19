//package org.example.aitestpro.configuration;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//@Configuration
//public class SswaggerConfig2 {
////    @Bean
////    public OpenAPI customOpenAPI() {
////        final String securitySchemeName = "bearerAuth";
////        return new OpenAPI()
////                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
////                .components(new io.swagger.v3.oas.models.Components()
////                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
////                                .name("Authorization")
////                                .type(SecurityScheme.Type.HTTP)
////                                .scheme("bearer")
////                                .bearerFormat("JWT")))
////                .info(new Info().title("Your API Title").version("1.0"));
////    }
//    @Bean
//    public OpenAPI customOpenAPI() {
//        final String securitySchemeName = "bearerAuth";
//        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
//                .components(new io.swagger.v3.oas.models.Components()
//                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
//                                .name("Authorization")
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT")))
//                .info(new Info().title("Demo Spring Boot 3 API")
//                        .description("This is a demo application for Spring Boot 3 with OpenAPI integration.")
//                        .version("1.0.0")
//                        .license(new License().name("name :JD").url("https://www.jianshu.com/u/007e515c5613"))
//                        .contact(new Contact().name("JD2017").email("964321735@qq.com").url("https://www.jianshu.com/u/007e515c5613"))
//                );
//    }
//    @Bean
//    @Primary
//    public GroupedOpenApi publicApi() {
//        return GroupedOpenApi.builder()
//                .group("public")
//                .pathsToMatch("/**")
//                .build();
//    }
//
//}
