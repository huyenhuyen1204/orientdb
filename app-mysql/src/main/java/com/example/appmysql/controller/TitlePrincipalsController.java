//package com.example.appmysql.controller;
//
//import com.example.appmysql.Utils.TitlePrincipalsRequest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/app")
//public class TitlePrincipalsController {
//
//    public static final Logger logger = LoggerFactory.getLogger(TitlePrincipalsController.class);
//
//    @Autowired
//    JdbcTemplate jdbc;
//
//
//
//    @GetMapping("/mysql/select/{year}")
//    Double getAllByCategory(@Valid @PathVariable("year") String c){
//        String sql = "SELECT * FROM title_principals WHERE category = " + "'" +c + "'";
//        long start = System.nanoTime();
//        logger.info("start: " + sql);
//        jdbc.execute(sql);
//        logger.info("end: ");
//        long end = System.nanoTime();
//        logger.info("time: " + (end-start)/1000000000);
//        return (double) (end-start)/1000000000;
//    }
//
//    @PostMapping("/mysql/insert")
//    Double createElement(@RequestBody TitlePrincipalsRequest titlePrincipalsRequest){
//        long start = System.nanoTime();
//        jdbc.update("Insert Into title_principals (tconst, ordering, nconst, category)  VALUES " +
//                        "(?, ?, ?, ?)",titlePrincipalsRequest.getTconst(),
//                titlePrincipalsRequest.getOrdering(),
//                titlePrincipalsRequest.getNconst(),
//                titlePrincipalsRequest.getCategory());
//        long end = System.nanoTime();
//        return (double) (end-start)/1000000000;
//
//    }
//
//    @DeleteMapping("/mysql/delete")
//    Double delete(String id){
//        long start = System.nanoTime();
//        jdbc.execute("Delete FROM title_principals Where tconst =" + id);
//        long end = System.nanoTime();
//        return (double) (end-start)/1000000000;
//    }
//
//    @PutMapping("/mysql/update")
//    Double update(String id, String category){
//        long start = System.nanoTime();
//
//        jdbc.update("Update title_principals SET category =" + category);
//        long end = System.nanoTime();
//        return (double) (end-start)/1000000000;
//    }
//    //TODO join vẫn làm
//}
