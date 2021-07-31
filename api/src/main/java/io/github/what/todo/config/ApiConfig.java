package io.github.what.todo.config;

import io.github.what.todo.annotation.Generated;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class ApiConfig {

    @Configuration
    @ComponentScan("io.github.what.todo")
    @PropertySource("classpath:application.properties")
    public static class StandardComponentScan {
    }

    @Profile(("!test"))
    @Configuration
    @ComponentScan(basePackages = "io.github.what.todo")
    @PropertySource("classpath:application.properties")
    @Generated
    public static class SecurityComponentScan {
    }
}
