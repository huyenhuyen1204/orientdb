package com.example.appmysql.repository;

import com.example.appmysql.Utils.OutputList;
import com.example.appmysql.Utils.OutputRow;

public interface BaseService {
    com.example.apporientdb.entry.TitlePrincipals getElement(String id);
    OutputList getAll();
    OutputRow createElement(NameBasicsRequest nameBasicsRequest);
    String delete(String id);
    OutputRow update(String id, String primaryName);
}
