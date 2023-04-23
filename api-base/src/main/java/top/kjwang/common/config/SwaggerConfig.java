package top.kjwang.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kjwang
 * @date 2023/4/23 21:34
 * @description SwaggerConfig Swagger 配置
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"top.kjwang"};
        return GroupedOpenApi.builder().group("api boot")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenApi() {
        Contact contact = new Contact();
        contact.setName("mqxu@gmail.com");

        return new OpenAPI().info(new Info()
                .title("接口文档")
                .description("接口文档")
                .contact(contact)
                .version("1.0.0")
                .termsOfService("https://kjwang.top"));
    }

}