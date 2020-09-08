package com.excelupload.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.excelupload.entity.StockPrice;

public class ExcelHelper {
	
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id","Company Code", "Stock Exchange", "Current Price", "Date" , "Time" };
	  static String SHEET = "sample_stock_data";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  } 

	  public static List<StockPrice> excelToStockPrices(InputStream is) {
	    try {
	    	
	      Workbook workbook = new XSSFWorkbook(is);
	      

	      Sheet sheet = workbook.getSheetAt(0);
	      Iterator<Row> rows = sheet.rowIterator();

	      List<StockPrice> StockPrices = new ArrayList<StockPrice>();

	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow =rows.next();

	        // skip header
	        if (rowNumber == 0) {
	          rowNumber++;
	          continue;
	        } 
	        
	        CreationHelper createHelper = workbook.getCreationHelper();
	    	CellStyle cellStyle = workbook.createCellStyle();
	    	cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d-m-yy"));


	        Iterator<Cell> cellsInRow = currentRow.iterator();

	        StockPrice StockPrice = new StockPrice();

	        int cellIdx = 0;
	        while (cellsInRow.hasNext()) {
	          Cell currentCell = cellsInRow.next();
	        DataFormatter df = new DataFormatter();
	  		String value = df.formatCellValue(currentCell);
	  		value = value.trim();
	  		System.out.println(value);

	          switch (cellIdx) {
	          case 0: 
	        	  StockPrice.setId(Integer.parseInt(value));
	          case 1:
	            String cc = value.replaceAll("\u00A0", "");
	  			System.out.println(cc);
	  			StockPrice.setCompanyCode(cc);
				break;

	          case 2:
	            StockPrice.setStockExchange(value);
	            break;

	          case 3:
	            StockPrice.setCurrentPrice(Float.parseFloat(value));
	            break;

	          case 4: 
	            
	            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
				Date d = currentCell.getDateCellValue();
				String ds = formatter1.format(d);
				System.out.println(ds);
				StockPrice.setDate(LocalDate.parse(ds, format));
				System.out.println(ds);
				break;
	            
	          case 5:
		        StockPrice.setTime(value);
		        break;

	          default:
	            break;
	          }

	          cellIdx++;
	        }

	        StockPrices.add(StockPrice);
	      }

	      workbook.close();

	      return StockPrices;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }
	 

}

