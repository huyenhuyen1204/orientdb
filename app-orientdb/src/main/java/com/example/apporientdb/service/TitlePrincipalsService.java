//package com.example.apporientdb.service;
//
//
//import com.example.apporientdb.Utils.OutputList;
//import com.example.apporientdb.Utils.OutputRow;
//import com.example.apporientdb.Utils.TitlePrincipalsRequest;
//import com.example.apporientdb.entry.TitlePrincipals;
//import com.example.apporientdb.interfaces.InterfaceBase.TitlePrincipalsBase;
//import com.example.apporientdb.interfaces.repositorys.TitlePrincipalsRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TitlePrincipalsService implements TitlePrincipalsBase {
//
//    public static final Logger logger = LoggerFactory.getLogger(TitlePrincipalsService.class);
//
//    @Autowired
//    private TitlePrincipalsRepository titlePrincipalsRepository;
//
//    @Override
//    public TitlePrincipals getElement(String id) {
//        return titlePrincipalsRepository.getById(id);
//    }
//
//    @Override
//    public OutputList getAll() {
//        //check time
//        Long start = System.nanoTime();
//        List<TitlePrincipals> list = titlePrincipalsRepository.getAll();
//        Long end = System.nanoTime();
//
//        OutputList o = new OutputList();
//        o.setList(list.subList(0, 30));
//        o.setRecords(list.size());
//        o.setTime((end-start)/1000000000);
//
//        logger.info("Records: " + list.size());
//        logger.info("Time: " + (end-start)/1000000000 + "ms");
//
//        return o;
//    }
//
//
//
//    @Override
//    public OutputRow createElement(TitlePrincipalsRequest titlePrincipalsRequest) {
//        TitlePrincipals titlePrincipals = new TitlePrincipals(titlePrincipalsRequest);
//        long start = System.nanoTime();
//        titlePrincipalsRepository.save(titlePrincipals);
//        long end = System.nanoTime();
//        double a = (end-start)/1000000000;
//        logger.info("Time insert: "+ a);
//
//        return new OutputRow( a,  1, titlePrincipals) ;
//    }
//
//    @Override
//    public String delete(String id) {
//        TitlePrincipals titlePrincipals = titlePrincipalsRepository.getById(id);
//        if(titlePrincipals == null){
//            return "Not Found with ID: " + id;
//        }
//        long start = System.nanoTime();
//        titlePrincipalsRepository.deleteById(id);
//        long end = System.nanoTime();
//        double a = (end - start)/1000000000;
//        return Double.toString(a);
//    }
//
//    @Override
//    public OutputRow update(String id, String category) {
//        TitlePrincipals nameBasics = titlePrincipalsRepository.getById(id);
//        nameBasics.setCategory(category);
//        long start = System.nanoTime();
//        titlePrincipalsRepository.update(id, category);
//        long end = System.nanoTime();
//        return new OutputRow((end-start)/1000000000, 1, nameBasics);
//    }
//}
