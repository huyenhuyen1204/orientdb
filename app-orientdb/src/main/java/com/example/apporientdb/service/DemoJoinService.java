package com.example.apporientdb.service;

import com.example.apporientdb.Utils.OutputDemoJoin;
import com.example.apporientdb.Utils.OutputList;
import com.example.apporientdb.interfaces.repositorys.DemoJoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Khong demo join vi time qua lau
 */
@Service
public class DemoJoinService {
    @Autowired
    private DemoJoinRepository demo;

//    public OutputList join(){
//
//        long start = System.nanoTime();
//        List<Object[]> list = demo.join();
//        long end = System.nanoTime();
//
//        List<OutputDemoJoin> output = new ArrayList<OutputDemoJoin>();
//        for(Object[] obj : list){
//            OutputDemoJoin  o = new OutputDemoJoin((String)obj[0],(String) obj[1],(String) obj[2]);
//            output.add(o);
//        }
//        return new OutputList((end-start)/1000000000, 1,output.subList(0,30) );
//    }
}
