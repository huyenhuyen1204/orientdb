package com.example.appmysql.repository;

import com.example.appmysql.entry.NameBasics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.orient.commons.repository.*;

import java.util.List;

@Repository
public interface NameBasicsRepository extends OrientRepository<NameBasics> {
    @Query(value = "SElECT * FROM name_basics", nativeQuery = true)
    List<NameBasics> getAll();

    @Query(value = "SELECT * FROM name_basics Where name_basics.nconst = :nc", nativeQuery = true)
    NameBasics getById(@Param("nc") String ncost);
}
