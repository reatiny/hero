package xyz.ray.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"xyz.ray.controller", "xyz.ray.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
