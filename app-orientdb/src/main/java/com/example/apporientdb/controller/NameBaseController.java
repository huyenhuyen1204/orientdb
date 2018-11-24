package com.example.apporientdb.controller;

import com.example.apporientdb.Utils.NameBasicsRequest;
import com.example.apporientdb.Utils.OutputList;
import com.orientechnologies.orient.jdbc.OrientJdbcConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/orientdb")
public class NameBaseController {

    public static final Logger logger = LoggerFactory.getLogger(NameBaseController.class);

    @Autowired
    public Connection connection;

    @GetMapping("/get")
    public Connection get() throws SQLException, ClassNotFoundException {
        Class.forName("com.orientechnologies.orient.jdbc.OrientJdbcDriver");
        Properties info = new Properties();
        info.put("user", "admin");
        info.put("password", "admin");

        Connection conn = (OrientJdbcConnection) DriverManager.getConnection("jdbc:orient:remote:178.128.58.224/orientdb", info);
        return conn;
    }

    @GetMapping("/select")
    public String getNameBasics(@RequestParam Long bYear) throws SQLException {
        Statement stmt = connection.createStatement();
        Long start = System.nanoTime();
        logger.info("Start: "+ start);
        ResultSet rs = stmt.executeQuery("SELECT * FROM NameBasics WHERE birthYear =" + bYear + " LIMIT 10");
        logger.info("exe...");
        rs.next();
        logger.info("rs.next(): "+ rs.next());
        Long end = System.nanoTime();
        logger.info("end :" + end);
        logger.info("rs: "+ rs.getArray("nconst") );
        List<NameBasicsRequest> list =  new ArrayList<> ();


        rs.close();
        stmt.close();
        return "OK:";
    }
}
