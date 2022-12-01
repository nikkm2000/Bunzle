package com.eperium.main;

import java.io.File;
import java.io.FilenameFilter;

public class XlsFilter implements FilenameFilter {
	
    
	   @Override
	  public boolean accept(File directory, String fileName) {
	
	        if (fileName.endsWith(".xls")) {
	
	            return true;
	
	        }
	     return false;


}
}
