package ru.itis.trofimoff.form.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import ru.itis.trofimoff.form.repository.user.UserRepositoryImpl;
import ru.itis.trofimoff.form.services.user.UserServiceImpl;
import ru.itis.trofimoff.form.services.validators.UserValidator;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan("ru.itis.trofimoff.form.controllers")
@ComponentScan("ru.itis.trofimoff.form.repository.utils")
@EnableWebMvc
@PropertySource("classpath:db.properties")
public class Config implements WebMvcConfigurer {

  @Autowired
  private Environment environment;

  @Bean
  public FreeMarkerViewResolver freeMarkerViewResolver(){
    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
    resolver.setSuffix(".ftl");
    return resolver;
  }

  @Bean
  public FreeMarkerConfigurer freeMarkerConfig(){
    FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
    configurer.setTemplateLoaderPath("/WEB-INF/fremarker/");
    return configurer;
  }

  @Bean
  public UserValidator validator(){
    return new UserValidator();
  }

  @Bean
  public UserServiceImpl userService() {
    return new UserServiceImpl(userRepository());
  }

  @Bean
  public UserRepositoryImpl userRepository() {
    return new UserRepositoryImpl(dataSource());
  }

  @Bean
  public DataSource dataSource() {
    return new HikariDataSource(hikariConfig());
  }

  @Bean
  public HikariConfig hikariConfig() {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setJdbcUrl(environment.getProperty("db.url"));
    hikariConfig.setMaximumPoolSize(Integer.parseInt(Objects.requireNonNull(environment.getProperty("db.hikari.max-pool-size"))));
    hikariConfig.setUsername(environment.getProperty("db.username"));
    hikariConfig.setPassword(environment.getProperty("db.password"));
    hikariConfig.setDriverClassName(environment.getProperty("db.driver.classname"));
    return hikariConfig;
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("form");
    registry.addViewController("/").setViewName("profile");
  }
}