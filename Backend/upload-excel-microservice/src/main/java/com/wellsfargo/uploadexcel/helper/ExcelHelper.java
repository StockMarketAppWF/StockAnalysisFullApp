package com.wellsfargo.uploadexcel.helper;

import java.sql.Time;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
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
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.entity.StockDetailsEntity;
import com.wellsfargo.uploadexcel.util.UploadExcelUtil;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "company_id", "exchange_id", "price", "date", "time" };
	static String SHEET = "Sheet";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<StockDetailsEntity> excelToStockDetailsFromExcel(InputStream inputStream) {
		try {
			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<StockDetailsEntity> stockDetailsList = new ArrayList<StockDetailsEntity>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				CreationHelper createHelper = workbook.getCreationHelper();
				CellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d-m-yy"));

				Iterator<Cell> cellsInRow = currentRow.iterator();

				StockDetailsEntity stockDetail = new StockDetailsEntity();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					DataFormatter df = new DataFormatter();
					String value = df.formatCellValue(currentCell);
					value = value.trim();

					switch (cellIdx) {
					case 0:
						String cc = value.replaceAll("\u00A0", "");
						stockDetail.setCompany_id(Integer.parseInt(cc));
						break;

					case 1:
						stockDetail.setExchange_id(Integer.parseInt(value));
						break;

					case 2:
						stockDetail.setPrice(Float.parseFloat(value));
						break;

					case 3:
						DateTimeFormatter format = DateTimeFormatter.ofPattern(UploadExcelUtil.DATE_FORMAT);
						SimpleDateFormat formatter1 = new SimpleDateFormat(UploadExcelUtil.DATE_FORMAT);
						Date d = currentCell.getDateCellValue();
						String ds = formatter1.format(d);
						stockDetail.setDate(LocalDate.parse(ds, format));
						break;

					case 4:
						stockDetail.setTime( LocalTime.parse(value,  DateTimeFormatter.ISO_TIME));
						break;

					default:
						break;
					}
					cellIdx++;
				}
				stockDetailsList.add(stockDetail);
			}
			workbook.close();
			return stockDetailsList;
		} catch (Exception e) {
			throw new RuntimeException(UploadExcelUtil.FILE_PARSE_EXCEPTION_MESSAGE +e.getMessage());
		}
	}
}