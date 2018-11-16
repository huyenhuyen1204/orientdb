package com.example.apporientdb.service;

import com.example.apporientdb.Utils.NameBasicsRequest;
import com.example.apporientdb.Utils.OutputList;
import com.example.apporientdb.Utils.OutputRow;
import com.example.apporientdb.entry.NameBasics;
import com.example.apporientdb.interfaces.InterfaceBase.NameBasicsBase;
import com.example.apporientdb.interfaces.repositorys.NameBasicsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameBasicsService implements NameBasicsBase {

    public static final Logger logger = LoggerFactory.getLogger(TitlePrincipalsService.class);

    @Autowired
    private NameBasicsRepository nameBasicsRepository;

    @Override
    public NameBasics getElement(String id) {
        return nameBasicsRepository.getById(id);    }

    @Override
    public OutputList getAllByStartYear(Long sYear) {
        Long start = System.nanoTime();
        List<NameBasics> list = nameBasicsRepository.getAllByStartYear(sYear);
        Long end = System.nanoTime();

        OutputList o = new OutputList();
        if(list.size() > 30) {
            o.setList(list.subList(0, 30));
        }
        o.setRecords(list.size());
        o.setTime((end-start)/1000000000);

        logger.info("Records: " + list.size());
        logger.info("Time: " + (end-start)/1000000 + "ms");

        return o;    }

    @Override
    public OutputRow createElement(NameBasicsRequest titlePrincipalsRequest) {
        NameBasics nameBasics = new NameBasics(titlePrincipalsRequest);
        long start = System.nanoTime();
        nameBasicsRepository.save(nameBasics);
        long end = System.nanoTime();
        double a = (end-start)/1000000;
        logger.info("Time insert: "+ a);

        return new OutputRow( a,  1, nameBasics) ;
    }

    @Override
    public String delete(String id) {
        NameBasics nameBasics = nameBasicsRepository.getById(id);
        if(nameBasics == null){
            return "Not Found with ID: " + id;
        }
        long start = System.nanoTime();
        nameBasicsRepository.deleteById(id);
        long end = System.nanoTime();
        double a = (end - start)/1000000;
        return Double.toString(a);
    }

    @Override
    public OutputRow update(String id, String newName) {
        NameBasics nameBasics = nameBasicsRepository.getById(id);
        nameBasics.setPrimaryName(newName);
        long start = System.nanoTime();
        nameBasicsRepository.update(id, newName);
        long end = System.nanoTime();
        return new OutputRow((end-start)/1000000, 1, nameBasics);
    }
}
