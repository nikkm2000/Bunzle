package com.eperium.main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExistingMerge 
{
	 public static void mergeExcelFiles(/*FileInputStream f111, */List<FileInputStream> list) throws IOException {
		   
		    File file=new File("./MergedReport/SummaryReport.xls");
		    
			FileInputStream f111= new FileInputStream(file);
		    HSSFWorkbook book = new HSSFWorkbook(f111);
		    HSSFSheet sheet = book.getSheet("SummaryReport.xls");
		    
		    for (FileInputStream fin : list) {
		      HSSFWorkbook b = new HSSFWorkbook(fin);
		      for (int i = 0; i < b.getNumberOfSheets(); i++) {
		        copySheets(book, sheet, b.getSheetAt(i));
		      }
		    }
		    
		    try {
		      writeFile(book, file);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
		  
		  protected static void writeFile(HSSFWorkbook book, File file) throws Exception {
		    FileOutputStream out = new FileOutputStream(file);
		    book.write(out);
		    out.close();
		  }
		  
		  private static void copySheets(HSSFWorkbook newWorkbook, HSSFSheet newSheet, HSSFSheet sheet){  
			System.out.println(newSheet.getLastRowNum()+"okok");
		    copySheets(newWorkbook, newSheet, sheet, true);
		  }     

		  private static void copySheets(HSSFWorkbook newWorkbook, HSSFSheet newSheet, HSSFSheet sheet, boolean copyStyle){     
		    int newRownumber = newSheet.getLastRowNum();
		    System.out.println(newRownumber+"BIbubu");
		    /*if(newRownumber!=0)
		    {
		    	newRownumber=newRownumber;//+1;
		    }*/
		    int maxColumnNum = 0;     
		    Map<Integer, HSSFCellStyle> styleMap = (copyStyle) ? new HashMap<Integer, HSSFCellStyle>() : null;    
		    
		    for (int i = sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++) {     //+1
		      HSSFRow srcRow = sheet.getRow(i); //i    
		      HSSFRow destRow = newSheet.createRow(i + newRownumber);//(i + newRownumber);    
		      if (srcRow != null) {     
		        copyRow(newWorkbook, sheet, newSheet, srcRow, destRow, styleMap);     
		        if (srcRow.getLastCellNum() > maxColumnNum) {     
		            maxColumnNum = srcRow.getLastCellNum();     
		        }     
		      }     
		    }     
		    for (int i = 0; i <= maxColumnNum; i++) {     
		      newSheet.setColumnWidth(i, sheet.getColumnWidth(i));     
		    }     
		  }     
		  
		  public static void copyRow(HSSFWorkbook newWorkbook, HSSFSheet srcSheet, HSSFSheet destSheet, HSSFRow srcRow, HSSFRow destRow, Map<Integer, HSSFCellStyle> styleMap) {     
		    destRow.setHeight(srcRow.getHeight());
		    for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {     
		      HSSFCell oldCell = srcRow.getCell(j);
		      HSSFCell newCell = destRow.getCell(j);
		      if (oldCell != null) {     
		        if (newCell == null) {     
		          newCell = destRow.createCell(j);     
		        }     
		        copyCell(newWorkbook, oldCell, newCell, styleMap);
		      }     
		    }                
		  }
		  
		  public static void copyCell(HSSFWorkbook newWorkbook, HSSFCell oldCell, HSSFCell newCell, Map<Integer, HSSFCellStyle> styleMap) {      
		    if(styleMap != null) {     
		      int stHashCode = oldCell.getCellStyle().hashCode();     
		      HSSFCellStyle newCellStyle = styleMap.get(stHashCode);     
		      if(newCellStyle == null){     
		        newCellStyle = newWorkbook.createCellStyle();     
		        newCellStyle.cloneStyleFrom(oldCell.getCellStyle());     
		        styleMap.put(stHashCode, newCellStyle);     
		      }     
		      newCell.setCellStyle(newCellStyle);   
		    }     
		    switch(oldCell.getCellType()) {     
		      case HSSFCell.CELL_TYPE_STRING:     
		        newCell.setCellValue(oldCell.getRichStringCellValue());     
		        break;     
		      case HSSFCell.CELL_TYPE_NUMERIC:     
		        newCell.setCellValue(oldCell.getNumericCellValue());     
		        break;     
		      case HSSFCell.CELL_TYPE_BLANK:     
		        newCell.setCellType(HSSFCell.CELL_TYPE_BLANK);     
		        break;     
		      case HSSFCell.CELL_TYPE_BOOLEAN:     
		        newCell.setCellValue(oldCell.getBooleanCellValue());     
		        break;     
		      case HSSFCell.CELL_TYPE_ERROR:     
		        newCell.setCellErrorValue(oldCell.getErrorCellValue());     
		        break;     
		      case HSSFCell.CELL_TYPE_FORMULA:     
		        newCell.setCellFormula(oldCell.getCellFormula());     
		        break;     
		      default:     
		        break;     
		    }
		  }

	      public static void main(String[] args) throws IOException {
		
	    	File srcFile=new File("./src/main/resources/SampleMergedFile/SummaryReport.xls");
	  	    File destFile=new File("./MergedReport/SummaryReport.xls");
	  	    FileUtils.copyFile(srcFile, destFile);
	      String dirs="./TestcasesReports";
	      findExcelReports(dirs);
	      /*List<FileInputStream> lists2=findExcelReports(dirs);
	      mergeExcelFiles(lists2);*/
	/*
			
			1- One example file must be there
			2- Copy the above file under Report merge folder and place it there
			3- Get all the excel Reports(fins) under TestcasesReports
			4- add them to list
			DONE
		
		*/
		
		
		 
	}

	private static /*List<FileInputStream>*/void findExcelReports(String dir) throws IOException {
		//String file_path = "./TestcasesReports";
		
		 File directory = new File(dir);
		// FilenameFilter filter = new XlsFilter();
		 File[] files = directory.listFiles();
		 List<FileInputStream> lists=new ArrayList<FileInputStream>();
		  for(File f : files)
		  {
	            if (f.isFile() && f.getName().endsWith(".xls")){
	            	lists.add(new FileInputStream(new File(f.getAbsolutePath())));
	            	
	            //	FileInputStream f1= new FileInputStream(new File(f.getAbsolutePath()));
	                System.out.println(f.getAbsolutePath());
	            } else if (f.isDirectory()){
	            	findExcelReports(f.getAbsolutePath());
	            }
	        }
		  mergeExcelFiles(lists);
	}

	
}
