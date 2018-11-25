package com.example.apporientdb;

import com.orientechnologies.orient.jdbc.OrientJdbcConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
public class AppOrientdbApplication {

    @Autowired
    public Connection connection;

    public static void main(String[] args) {
        SpringApplication.run(AppOrientdbApplication.class, args);
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

        Connection conn = (OrientJdbcConnection) DriverManager.getConnection("jdbc:orient:remote:178.128.58.224:2424/orientdb", info);
        return conn;
    }

}
