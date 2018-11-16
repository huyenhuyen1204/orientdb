package com.example.apporientdb.interfaces.InterfaceBase;

import com.example.apporientdb.Utils.NameBasicsRequest;
import com.example.apporientdb.Utils.OutputList;
import com.example.apporientdb.Utils.OutputRow;
import com.example.apporientdb.entry.NameBasics;

public interface NameBasicsBase {
    NameBasics getElement(String id);

    OutputList getAllByStartYear(Long sYear);

    OutputRow createElement(NameBasicsRequest titlePrincipalsRequest);

    String delete(String id);

    OutputRow update(String id, String category);
}
