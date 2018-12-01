package com.example.appmysql.controller;

import com.example.appmysql.Utils.InputUpdate;
import com.example.appmysql.Utils.NameBasicsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/mysql")
public class MysqlNameBasicsController {
    @Autowired
    JdbcTemplate jdbc;

    @CrossOrigin
    @GetMapping("/select")
    Double getAllByStartYear(@RequestParam Long bYear, @RequestParam int limit){
        String sql = "SELECT * FROM name_basics WHERE birthYear = " + bYear + " LIMIT " + limit;
        long start = System.nanoTime();
        jdbc.execute(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

//    @CrossOrigin
    @PostMapping("/insert")
    Double createElement( @Valid @RequestBody NameBasicsRequest titlePrincipalsRequest){
        long start = System.nanoTime();
        jdbc.update("INSERT INTO name_basics(nconst, primaryName, birthYear)  VALUES (?, ?, ?)",
                titlePrincipalsRequest.getNconst(),
                titlePrincipalsRequest.getPrimaryName(),
                titlePrincipalsRequest.getBirthYear());
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;

    }

    @CrossOrigin
    @DeleteMapping("/delete")
    Double delete(@RequestParam String nconst){
        long start = System.nanoTime();
        String sql = "DELETE FROM name_basics WHERE nconst = " + "'" + nconst +  "'";
            jdbc.execute(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

    @CrossOrigin
    @PutMapping("/update")
    Double update(@Valid @RequestBody InputUpdate inputUpdate){
        long start = System.nanoTime();
        String sql = "UPDATE name_basics SET primaryName = " +  "'" + inputUpdate.getCategory() + "'" + "WHERE nconst = " + "'" + inputUpdate.getId() + "'"  ;
        jdbc.update(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

    //Join title_basic and title_ratings
    @CrossOrigin
    @GetMapping("/join")
    Double join(@RequestParam Long vote, @RequestParam Long limit){
        long start= System.nanoTime();
        String sql = "select title_basics.tconst, title_basics.primaryTitle from title_basics Where tconst in (select tconst from title_ratings Where numVotes >= "+ vote+ ") Limit " + limit;
        jdbc.execute(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

}
