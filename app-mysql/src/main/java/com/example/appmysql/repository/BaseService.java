package com.example.appmysql.repository;

import com.example.appmysql.Utils.NameBasicsRequest;
import com.example.appmysql.Utils.OutputList;
import com.example.appmysql.Utils.OutputRow;
import com.example.appmysql.entry.NameBasics;

public interface BaseService {
    NameBasics getElement(String id);
    OutputList getAll();
    OutputRow createElement(NameBasicsRequest nameBasicsRequest);
    double delete(String id);
}
