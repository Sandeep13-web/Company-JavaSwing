package org.personal.company;

import java.util.Map;

public interface DaoCompany {
   void add(Company company);

    int remove(String companyName);

    void addOrRemove();

    Map<String, Company> findAll();

    Company findOne(String companyName); 
}
