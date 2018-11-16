package com.example.appmysql.repository;

import com.example.appmysql.entry.TitleAkas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.orient.commons.repository.OrientRepository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public interface TitleAkasRepository {
    @Query("select ta from TitleAkas ta")
    List<TitleAkas> getAll();
}

//name.bsaics title rating
