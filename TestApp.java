package com.jdbc.application;

import java.sql.SQLException;
import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
      System.out.println("option:");
      System.out.println("1-create");
      System.out.println("2-read");
      System.out.println("3-update");
      System.out.println("4-delete");
      
      Scanner scanner=new Scanner(System.in);
      System.out.println("kindly enter an option:");
      int option=scanner.nextInt();
      try
      {
      if(option==1)
      {
    	  InsertApp.insertApp();  
      }
      if(option==2)
      {
    	  SelectApp.selectApp();
    	  
      }
      if(option==3)
      {
    	  UpdateApp.updateApp();
      }
      if(option==4)
      {
    	  DeleteApp.deleteApp();
      }
      }
      finally {
    	  if(scanner!=null)
    	  {
    		  scanner.close();
    	  }
      }
      
	}

}
