package org.personal.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DaoImplCompany implements DaoCompany{
   
    Map<String, Company> Company = new TreeMap<>();

    public static File file = new File("E:\\FileIO\\company.csv");

    @Override
    public void add(Company company) {
        Company.put(company.getName(), company);
        addOrRemove();
    }

    @Override
    public void addOrRemove() {
        try {
            FileWriter fWriter = new FileWriter(file);
            for (Map.Entry c : Company.entrySet()) {
                Company companyToUpdate = (Company) c.getValue();
                fWriter.write(companyToUpdate.getName() + "," + companyToUpdate.getAddress() + "," + companyToUpdate.getContact()
                        + "," + companyToUpdate.getEmail() + "\n");
            }
            fWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public int remove(String companyName) {
        Company.remove(companyName);
        addOrRemove();
        return 1;
    }

    @Override
    public Map<String, Company> findAll() {
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String companyData[] = line.split(",");
            Company company = new Company(companyData[0], companyData[1], companyData[2], companyData[3]);
            Company.put(company.getName(), company);
        }
        reader.close();
        return Company;
    }

    @Override
    public Company findOne(String companyName) {
        for (Map.Entry comp : Company.entrySet()) {
            if (comp.getKey() == companyName) {
                Company com = (Company) comp.getValue();
                return com;
            }
        }
        return null;
    }
}
