package com.example.apporientdb.interfaces.repositorys;

import com.example.apporientdb.entry.TitlePrincipals;
import org.springframework.data.orient.commons.repository.OrientRepository;
import org.springframework.data.orient.commons.repository.annotation.Query;

import java.util.List;

public interface DemoJoinRepository extends OrientRepository<TitlePrincipals> {
    //TODO: sửa query join (k demo)
//    @Query("select ..  ")
//    List<Object[]> join();
}
