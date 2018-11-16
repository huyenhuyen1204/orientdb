package com.example.apporientdb.repository;

import com.example.apporientdb.entry.TitlePrincipals;
import org.springframework.data.orient.commons.repository.OrientRepository;
import org.springframework.data.orient.commons.repository.annotation.Query;

import java.util.List;

public interface DemoJoin extends OrientRepository<TitlePrincipals> {
    @Query("select basic.tconst, basic.primaryTitle, pri.category from title_basics basic join title_principals pri " +
            "ON basic.ncost = pri.ncost ")
    List<Object[]> join();
}
