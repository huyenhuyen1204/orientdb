package com.example.apporientdb.interfaces.repositorys;


import com.example.apporientdb.entry.TitlePrincipals;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.orient.commons.repository.OrientRepository;
import org.springframework.data.orient.commons.repository.annotation.Query;

import java.util.List;

public interface TitlePrincipalsRepository extends OrientRepository<TitlePrincipals> {
    @Query("select tp from title_principals tp")
    List<TitlePrincipals> getAll();

    @Query("select tp from title_principals tp Where tp.tconst = ? ")
    TitlePrincipals getById(String tcost);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE title_principals tp SET tp.category = ?2 WHERE tp.tconst = ?1")
    void update(String id, String newName);
}
