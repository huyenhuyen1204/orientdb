//package com.example.apporientdb.interfaces.repositorys;
//
//import com.example.apporientdb.entry.NameBasics;
////import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.orient.commons.repository.OrientRepository;
//import org.springframework.data.orient.commons.repository.annotation.Query;
//import org.springframework.data.orient.object.repository.OrientObjectRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface NameBasicsRepository extends OrientObjectRepository<NameBasics> {
//    @Query("select nb from NameBasics nb Where nb.birthYear = ?")
//    List<NameBasics> findByBirthYear(Long sYear);
//
////    @Query("select nb from NameBasics nb Where nb.nconst = ? ")
//    NameBasics findByNconst(String ncost);
//
////    @Modifying(clearAutomatically = true)
////    @Query("UPDATE NameBasics nb SET nb.primaryName = ?2 WHERE nb.nconst = ?1")
//    void update(String id, String newName);
//}
