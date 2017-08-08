package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelUtils {

	private HSSFWorkbook workbook = null;
	private HSSFSheet sheet = null;
	private FileInputStream inputStream =null;
	private String dataFilesDir="dataFiles";
	
	public void openExcel(String excelFileName, String sheetName) {
		try {
			ClassLoader classLoader=getClass().getClassLoader();
			File file=new File(classLoader.getResource(dataFilesDir+"/"+excelFileName).getFile());
			inputStream = new FileInputStream(file);
			workbook = new HSSFWorkbook(inputStream);
			sheet = workbook.getSheet(sheetName);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void closeExcel(){
		try{
			inputStream.close();
			workbook.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	// this method is only to get cell data
	public String getCellData(int rowIndex, int cellIndex){
		
		HSSFRow row= sheet.getRow(rowIndex);
		return getData(row, cellIndex);
	}
	
	private String getData(HSSFRow row, int cellIndex) {
		
		String cellData = null;
		
		HSSFCell cell=row.getCell(cellIndex);
		
		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
			cellData=cell.getNumericCellValue()+ "";
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_STRING){
			cellData=cell.getStringCellValue();
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
			cellData="";
		}
		
		return cellData;
	}
	
	// Method to call single row
	public String[] getRowData(int rowIndex)
	{
		HSSFRow row=sheet.getRow(rowIndex);
		int cellCount=row.getPhysicalNumberOfCells();
		String [] rowData=new String[cellCount];
		for(int i=0;i<cellCount;i++)
		{
			rowData[i]=getData(row,i);
		}
		return rowData;
	}
	
	public String[][] getAllRows(){
		int rowCount=getRowCount();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		HSSFRow row=null;
		String [][] allData=new String[rowCount][cellCount];
		for(int rowIndex=0;rowIndex<rowCount;rowIndex++)
		{
			row=sheet.getRow(rowIndex);
			for(int cellIndex=0;cellIndex<cellCount;cellIndex++)
			{
				allData[rowIndex][cellIndex]=getData(row, cellIndex);
			}
		}
		return allData;
	}
	
	private int getRowCount(){
		if(sheet !=null){
			return sheet.getPhysicalNumberOfRows();
		}
		else
		{
			return 0;
		}
	}
	
	public static void main(String[] args){
		
		ExcelUtils excelReader=new ExcelUtils();
		
		excelReader.openExcel("DataTest4.xls", "Sheet1");
		
		System.out.println(excelReader.getCellData(0, 0));
		
		String [] rowData=excelReader.getRowData(0);
		
		for(int i=0;i<rowData.length;i++)
		{
			System.out.print(rowData[i]+"");
		}
		
		String [][] allData=excelReader.getAllRows();
		int colCount=0;
		for(int i=0;i<allData.length;i++)
		{
			colCount=allData[i].length;
			for(int j=0;j<colCount;j++)
			{
		//	System.out.print(" "+allData[i][j]);
			}
			
			System.out.println();
		}
		excelReader.closeExcel();
	}
}