package com.example.appmysql.repository;


import com.example.appmysql.entry.TitlePrincipals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.orient.commons.repository.OrientRepository;

import java.util.List;

public interface TitlePrincipalsRepository extends OrientRepository<TitlePrincipals> {
    @Query("select tp from TitlePrincipals  tr")
    List<TitlePrincipals> getAll();
}
