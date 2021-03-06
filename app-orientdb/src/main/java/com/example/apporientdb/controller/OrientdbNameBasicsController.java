package com.example.apporientdb.controller;

import com.example.apporientdb.Utils.*;
import com.example.apporientdb.entry.NameBasics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orientdb")
public class OrientdbNameBasicsController {

    public static final Logger logger = LoggerFactory.getLogger(OrientdbNameBasicsController.class);

    @Autowired
    public Connection connection;


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
        return new OutputList((double)(end - start)/1000000000, list.size(), list);
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
             nameBasics = new NameBasics(rs.getString                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ("nconst"), rs.getString("primaryName"), rs.getLong("birthYear"), null, null);
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

    @GetMapping("/join")
    OutputList join(@RequestParam Long vote, @RequestParam Long limit) throws SQLException {
        Statement statement = connection.createStatement();
        //Trong file json da tao 1 canh (edge) from titleRatings -> titleBasics voi ten la "HasName"
        long start = System.nanoTime();
        ResultSet rs = statement.executeQuery("select out('HasName').tconst, out('HasName').primaryTitle, numVotes From titleratings where numVotes >="+ vote +" limit " + limit);
        long end = System.nanoTime();
        List<ResultJoin> list = new ArrayList<>();
        while (rs.next()){
            ResultJoin resultJoin= new ResultJoin();
            resultJoin.setTconst(rs.getString("out"));
            resultJoin.setPrimatytTitle(rs.getString("out2"));
            resultJoin.setNumVotes(rs.getLong("numVotes"));
            list.add(resultJoin);
        }
        return new OutputList((double) (end-start)/1000000000, list.size(), list);
    }


    @PutMapping("/update")
    OutputRow update(@Valid @RequestBody InputUpdate inputUpdate) throws SQLException {
        Statement statement = connection.createStatement();
        long start = System.nanoTime();
        ResultSet rs = statement.executeQuery("UPDATE NameBasics SET primaryName = " +  "'" + inputUpdate.getCategory() + "'" + " WHERE nconst = " + "'" + inputUpdate.getNconst() + "'");
        long end = System.nanoTime();
//
//        String a = rs.getString("primaryProfession");
//        String b = rs.getString("knownForTitles");
//        long c = 0;
//        c = rs.getLong("birthYear");

//        NameBasics nameBasics= null;
//        while (rs.next()) {
//            nameBasics = new NameBasics(inputUpdate.getNconst(), inputUpdate.getCategory(),
//                    rs.getLong("birthYear"),
//                    a,
//                    b);
//
//        }
        return new OutputRow( (double) (end-start)/1000000000, 1, null);
    }

}
