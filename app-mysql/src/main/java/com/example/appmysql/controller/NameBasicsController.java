//package com.example.appmysql.controller;
//
//import com.example.appmysql.Utils.NameBasicsRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/app")
//public class NameBasicsController {
//    @Autowired
//    JdbcTemplate jdbc;
//
////    @GetMapping("/mysql/select")
////    Double getAllByStartYear(@RequestParam("startYear") Long sYear){
////        String sql = "SELECT * FROM name_basics WHERE birthYear = " + sYear;
////        long start = System.nanoTime();
////        jdbc.execute(sql);
////        long end = System.nanoTime();
////        return (double) (end-start)/1000000;
////    }
//
//    @GetMapping("/mysql/select/{year}")
//    Double getAllByStartYear(@Valid @PathVariable("year") Long sYear){
//        String sql = "SELECT * FROM name_basics WHERE birthYear = " + sYear;
//        long start = System.nanoTime();
//        jdbc.execute(sql);
//        long end = System.nanoTime();
//        return (double) (end-start)/1000000;
//    }
//
//    @PostMapping("/mysql/insert")
//    Double createElement(@RequestBody NameBasicsRequest titlePrincipalsRequest){
//        long start = System.nanoTime();
//        jdbc.update("INSERT INTO name_basics(nconst, primaryName, birthYear)  VALUES (?, ?, ?)",
//                titlePrincipalsRequest.getNconst(),
//                titlePrincipalsRequest.getPrimaryName(),
//                titlePrincipalsRequest.getBirthYear());
//        long end = System.nanoTime();
//        return (double) (end-start)/1000000;
//
//    }
//
//    @DeleteMapping("/mysql/delete")
//    Double delete(String id){
//        long start = System.nanoTime();
//        String sql = "DELETE FROM name_basics WHERE nconst = " + id;
//            jdbc.execute(sql);
//        long end = System.nanoTime();
//        return (double) (end-start)/1000000;
//    }
//
//    @PutMapping("/mysql/update")
//    Double update(String id, String category){
//        long start = System.nanoTime();
//        String sql = "UPDATE name_basics SET primaryName = " + category;
//        jdbc.update(sql);
//        long end = System.nanoTime();
//        return (double) (end-start)/1000000;
//    }
//
//    //khong demo vi time qua lau
//    //
//    // @GetMapping("/mysql/join")
//    // Double join()
//}
