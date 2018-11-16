package com.example.appmysql.controller;

import com.example.appmysql.Utils.TitlePrincipalsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app")
public class TitlePrincipalsController {

    @Autowired
    JdbcTemplate jdbc;



    @GetMapping("/mysql/select/{year}")
    Double getAllByCategory(@Valid @PathVariable("year") String c){
        String sql = "SELECT * FROM title_principals WHERE category = " + c;
        long start = System.nanoTime();
        jdbc.execute(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000;
    }

    @PostMapping("/mysql/insert")
    Double createElement(@RequestBody TitlePrincipalsRequest titlePrincipalsRequest){
        long start = System.nanoTime();
        jdbc.update(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000;

    }

    @DeleteMapping("/mysql/delete")
    Double delete(String id){
        long start = System.nanoTime();

        jdbc.execute(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000;
    }

    @PutMapping("/mysql/update")
    Double update(String id, String category){
        long start = System.nanoTime();

        jdbc.update(sql);
        long end = System.nanoTime();
        return (double) (end-start)/1000000;
    }
}
