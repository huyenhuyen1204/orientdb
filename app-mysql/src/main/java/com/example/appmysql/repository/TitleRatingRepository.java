package com.example.appmysql.repository;


import com.example.appmysql.entry.TitleRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.orient.commons.repository.OrientRepository;

import java.util.List;

public interface TitleRatingRepository extends OrientRepository<TitleRating> {
    @Query("select tr from TitleRating tr")
    List<TitleRatingRepository> getAll();
}
