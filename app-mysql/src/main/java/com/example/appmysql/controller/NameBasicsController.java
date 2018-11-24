package com.example.appmysql.controller;

import com.example.appmysql.Utils.InputUpdate;
import com.example.appmysql.Utils.NameBasicsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app")
public class NameBasicsController {
    @Autowired
    JdbcTemplate jdbc;

    @GetMapping("/mysql/select")
    Double getAllByStartYear(@RequestParam Long sYear){
        String sql = "SELECT * FROM name_basics WHERE birthYear = " + sYear;
        long start = System.nanoTime();
        jdbc.execute(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

    @PostMapping("/mysql/insert")
    Double createElement(@RequestBody NameBasicsRequest titlePrincipalsRequest){
        long start = System.nanoTime();
        jdbc.update("INSERT INTO name_basics(nconst, primaryName, birthYear)  VALUES (?, ?, ?)",
                titlePrincipalsRequest.getNconst(),
                titlePrincipalsRequest.getPrimaryName(),
                titlePrincipalsRequest.getBirthYear());
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;

    }

    @DeleteMapping("/mysql/delete")
    Double delete(@RequestParam String nconst){
        long start = System.nanoTime();
        String sql = "DELETE FROM name_basics WHERE nconst = " + "'" + nconst +  "'";
            jdbc.execute(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

    @PutMapping("/mysql/update")
    Double update(@RequestBody InputUpdate inputUpdate){
        long start = System.nanoTime();
        String sql = "UPDATE name_basics SET primaryName = " +  "'" + inputUpdate.getCategory() + "'" + "WHERE nconst = " + "'" + inputUpdate.getId() + "'"  ;
        jdbc.update(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000000;
    }

}
