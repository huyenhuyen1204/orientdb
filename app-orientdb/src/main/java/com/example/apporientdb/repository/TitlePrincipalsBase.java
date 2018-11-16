package com.example.apporientdb.repository;

import com.example.apporientdb.Utils.OutputList;
import com.example.apporientdb.Utils.OutputRow;
import com.example.apporientdb.Utils.TitlePrincipalsRequest;
import com.example.apporientdb.entry.TitlePrincipals;

public interface TitlePrincipalsBase{

    TitlePrincipals getElement(String id);

    OutputList getAll();

    OutputRow createElement(TitlePrincipalsRequest titlePrincipalsRequest);

    String delete(String id);

    OutputRow update(String id, String category);
}
