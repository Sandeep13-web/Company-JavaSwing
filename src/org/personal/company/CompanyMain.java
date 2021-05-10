package org.personal.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CompanyMain {
  public static void main(String[] args) throws FileNotFoundException, IOException{
      
    DashboardUI dashboard = new DashboardUI();
    dashboard.setLocationRelativeTo(null);
    dashboard.setVisible(true);
        
    }
  
}
