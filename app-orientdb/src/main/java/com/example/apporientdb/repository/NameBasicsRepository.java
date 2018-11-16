package com.example.apporientdb.repository;

import com.example.apporientdb.entry.NameBasics;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.orient.commons.repository.OrientRepository;
import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameBasicsRepository extends OrientRepository<NameBasics> {
//    @Query(value = "SElECT * FROM name_basics", nativeQuery = true)
    @Query("select nb from name_basics nb")
    List<NameBasics> getAll();

//    @Query(value = "SELECT * FROM name_basics Where name_basics.nconst = :nc", nativeQuery = true)
    @Query("select nb from name_basics nb Where nb.nconst = ? ")
    NameBasics getById(String ncost);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE name_basics nb SET nb.primaryName = ?2 WHERE nb.nconst = ?1")
    void update(String id, String newName);
}
