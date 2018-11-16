//package com.example.appmysql.service;
//
//import com.example.appmysql.Utils.NameBasicsRequest;
//import com.example.appmysql.Utils.OutputList;
//import com.example.appmysql.Utils.OutputRow;
//import com.example.appmysql.entry.NameBasics;
//import com.example.appmysql.repository.BaseService;
//import com.example.appmysql.repository.NameBasicsRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//import static javafx.scene.input.KeyCode.O;
//
//@Service
//public class NameBasicsService implements BaseService {
//    public static final Logger logger = LoggerFactory.getLogger(NameBasicsService.class);
//
//    private NameBasicsRepository nameBasicsRepository;
//
//    /**
//     * Lay 1 row
//     * @param id
//     * @return
//     */
//    @Override
//    public NameBasics getElement(String id){
//        return nameBasicsRepository.getById(id);
//    }
//
//    /**
//     * Lay all row
//     * @return
//     */
//    @Override
//    public OutputList getAll(){
//
//        //check time
//        Long start = System.nanoTime();
//        List<NameBasics> nameBasics = nameBasicsRepository.getAll();
//        Long end = System.nanoTime();
//
//        OutputList o = new OutputList();
//        o.setList(nameBasics);
//        o.setRecords(nameBasics.size());
//        o.setTime((end-start)/1000);
//
//        logger.info("Records: " + nameBasics.size());
//        logger.info("Time: " + (end-start)/1000 + "ms");
//
//        return o;
//    }
//
//    /**
//     * tao 1 name basic
//     * @param nameBasicsRequest
//     * @return
//     */
//    @Override
//    public OutputRow createElement(NameBasicsRequest nameBasicsRequest){
//        //Co the them check id da ton tai
//
//        NameBasics nameBasics = new NameBasics(nameBasicsRequest);
//        long start = System.nanoTime();
//        nameBasicsRepository.save(nameBasics);
//        long end = System.nanoTime();
//        double a = (end-start)/1000;
//        logger.info("Time insert: "+ a);
//
//        return new OutputRow( a,  1, nameBasics) ;
//
//    }
//
//    @Override
//    public String delete(String id) {
//        NameBasics nameBasics = nameBasicsRepository.getById(id);
//        if(nameBasics == null){
//            return "Not Found with ID: " + id;
//        }
//        long start = System.nanoTime();
//        nameBasicsRepository.delete(nameBasics);
//        long end = System.nanoTime();
//        double a = (end - start)/1000;
//        return Double.toString(a);
//    }
//
//    /**
//     * update primaryName
//     * @param id
//     * @param primaryName
//     * @return
//     */
//    @Override
//    public OutputRow update(String id, String primaryName) {
//        NameBasics nameBasics = nameBasicsRepository.getById(id);
//        nameBasics.setPrimaryName(primaryName);
//        long start = System.nanoTime();
//        nameBasicsRepository.save(nameBasics);
//        long end = System.nanoTime();
//
//    }
//// Khi chay lai databases
////    /**
////     * update
////     * @param id
////     * @param pName
////     * @return
////     */
////    public OutputRow updateNameBasics(String id, String pName){
////        NameBasics nameBasics= nameBasicsRepository.getById(id);
////        OutputRow o = new OutputRow();
////        if(nameBasics != null) {
////
////        }
////        return null;
////    }
//
//
//}
