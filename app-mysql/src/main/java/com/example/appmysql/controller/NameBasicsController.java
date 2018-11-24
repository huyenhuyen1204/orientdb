package com.example.appmysql.controller;

import com.example.appmysql.Utils.InputUpdate;
import com.example.appmysql.Utils.NameBasicsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/mysql")
public class NameBasicsController {
    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("/select")
    Double getAllByStartYear(@RequestParam Long sYear, @RequestParam int limit){
        String sql = "SELECT * FROM name_basics WHERE birthYear = " + sYear + " LIMIT " + limit;
        long start = System.nanoTime();
        jdbc.execute(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

    @PostMapping("/insert")
    Double createElement(@RequestBody NameBasicsRequest titlePrincipalsRequest){
        long start = System.nanoTime();
        jdbc.update("INSERT INTO name_basics(nconst, primaryName, birthYear)  VALUES (?, ?, ?)",
                titlePrincipalsRequest.getNconst(),
                titlePrincipalsRequest.getPrimaryName(),
                titlePrincipalsRequest.getBirthYear());
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;

    }

    @DeleteMapping("/delete")
    Double delete(@RequestParam String nconst){
        long start = System.nanoTime();
        String sql = "DELETE FROM name_basics WHERE nconst = " + "'" + nconst +  "'";
            jdbc.execute(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

    @PutMapping("/update")
    Double update(@RequestBody InputUpdate inputUpdate){
        long start = System.nanoTime();
        String sql = "UPDATE name_basics SET primaryName = " +  "'" + inputUpdate.getCategory() + "'" + "WHERE nconst = " + "'" + inputUpdate.getId() + "'"  ;
        jdbc.update(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

}
