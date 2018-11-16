package com.example.apporientdb.interfaces.repositorys;



import com.example.apporientdb.entry.TitleRating;
import org.springframework.data.orient.commons.repository.OrientRepository;
import org.springframework.data.orient.commons.repository.annotation.Query;

import java.util.List;

public interface TitleRatingRepository extends OrientRepository<TitleRating> {
    @Query(value = "select tr from title_rating tr")
    List<TitleRatingRepository> getAll();
}
