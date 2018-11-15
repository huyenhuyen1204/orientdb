package com.example.appmysql.repository;

import com.example.appmysql.entry.TitleAkas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.orient.commons.repository.OrientRepository;

import java.util.List;

public interface TitleAkasRepository extends OrientRepository<TitleAkas> {
    @Query("select ta from TitleAkas ta")
    List<TitleAkas> getAll();
}

//name.bsaics title rating
