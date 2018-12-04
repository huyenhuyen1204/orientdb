package com.example.apporientdb;

import com.orientechnologies.orient.jdbc.OrientJdbcConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class AppOrientdbApplication {

    @Autowired
    public Connection connection;

    public static void main(String[] args) {
        SpringApplication.run(AppOrientdbApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                        .allowedHeaders("header1", "header2", "header3")
//                        .exposedHeaders("header1", "header2")
//                        .allowCredentials(false).maxAge(3600);
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);    return source;
    }

    @Bean
    public Connection connection() throws SQLException {
        Properties info = new Properties();
        info.put("user", "admin");
        info.put("password", "admin");

        info.put("db.usePool", "true"); // USE THE POOL
        info.put("db.pool.min", "3");   // MINIMUM POOL SIZE
        info.put("db.pool.max", "30");  // MAXIMUM POOL SIZE
        info.put("spark", "true"); // ENABLE Spark compatibility

//        Connection conn = (OrientJdbcConnection) DriverManager.getConnection("jdbc:orient:remote:localhost:2424/orientdb", info);

        Connection conn = (OrientJdbcConnection) DriverManager.getConnection("jdbc:orient:remote:128.199.205.8/orientdb", info);

        return conn;
    }

}
