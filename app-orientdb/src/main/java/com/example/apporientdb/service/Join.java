package com.example.apporientdb.service;

import com.example.apporientdb.Utils.OutputDemoJoin;
import com.example.apporientdb.Utils.OutputList;
import com.example.apporientdb.repository.DemoJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Join {
    @Autowired
    private DemoJoin demo;

    public OutputList join(){

        long start = System.nanoTime();
        List<Object[]> list = demo.join();
        long end = System.nanoTime();

        List<OutputDemoJoin> output = new ArrayList<OutputDemoJoin>();
        for(Object[] obj : list){
            OutputDemoJoin  o = new OutputDemoJoin((String)obj[0],(String) obj[1],(String) obj[2]);
            output.add(o);
        }
        return new OutputList((end-start)/1000, 1,output );
    }
}
