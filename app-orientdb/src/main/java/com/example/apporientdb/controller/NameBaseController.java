package com.example.apporientdb.controller;

import com.example.apporientdb.Utils.NameBasicsRequest;
import com.example.apporientdb.Utils.OutputList;
import com.example.apporientdb.Utils.OutputRow;
import com.example.apporientdb.entry.NameBasics;
import com.orientechnologies.orient.jdbc.OrientJdbcConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@RestController
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
    OutputList getNameBasics(@RequestParam Long bYear, @RequestParam int limit) throws SQLException {
        Statement stmt = connection.createStatement();

        Long start = System.nanoTime();
        ResultSet rs = stmt.executeQuery("SELECT * FROM NameBasics WHERE birthYear =" + bYear + " LIMIT " + limit);
        Long end = System.nanoTime();
        List<NameBasics> list =  new ArrayList<> ();
        while (rs.next()) {
            NameBasics nameBasics = new NameBasics(rs.getString("nconst"), rs.getString("primaryName"),
                    rs.getLong("birthYear"),
                    rs.getString("primaryProfession"), rs.getString("knownForTitles"));
            list.add(nameBasics);
        }
        rs.close();
        stmt.close();
        for(NameBasics a : list){
            System.out.println(a.getNconts());
        }
        return new OutputList((double)(end - start)/1000000000, limit, list);
    }

    @PostMapping("/insert")
    OutputRow createElement(@RequestBody NameBasicsRequest titlePrincipalsRequest) throws SQLException {
        Statement stmt = connection.createStatement();
        Long start = System.nanoTime();
        ResultSet rs = stmt.executeQuery("INSERT INTO NameBasics (nconst, primaryName, birthYear)  " +
                "VALUES ("
                + "'" + titlePrincipalsRequest.getNconst() + "'"+ ","
                +"'" + titlePrincipalsRequest.getPrimaryName() + "'"+  ","
                +"'"+ titlePrincipalsRequest.getBirthYear() + "'"+ ")");
        long end = System.nanoTime();
        NameBasics nameBasics = null;
        while(rs.next()) {
             nameBasics = new NameBasics(rs.getString("nconst"), rs.getString("primaryName"), rs.getLong("birthYear"), null, null);
        }

        return new OutputRow((double)(end - start)/1000000000, 1, nameBasics);
    }

    @DeleteMapping("/delete")
    OutputRow delete(@RequestParam String nconst) throws SQLException {
        Statement stmt = connection.createStatement();
        long start = System.nanoTime();
        ResultSet rs = stmt.executeQuery("DELETE FROM NameBasics WHERE nconst = " + "'" + nconst +  "'");
        long end = System.nanoTime();
        return new OutputRow( (double) (end-start)/1000000000, 1, null);
    }

}
