package com.wellsfargo.uploadexcel.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.xmlbeans.ResourceLoader;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.wellsfargo.uploadexcel.entity.StockDetailsEntity;
import com.wellsfargo.uploadexcel.helper.ExcelHelper;

@SpringBootTest
@RunWith(SpringRunner.class)
class UploadExcelFileControllerTest {
	
    @Test
    public void uploadFileTest() throws Exception {

        File initialFile = new File("C:\\Users\\Snehal\\Desktop\\sample_stock_data_check.xlsx");
        InputStream targetStream = new FileInputStream(initialFile);
        
        StockDetailsEntity details = new StockDetailsEntity();
        details.setCompany_id(1);
        details.setPrice((float)500);
        details.setDate(LocalDate.parse("2020-07-09"));
        details.setTime(LocalTime.parse("10:30:00"));
        details.setExchange_id(2);
        
        StockDetailsEntity entity = ExcelHelper.excelToStockDetailsFromExcel(targetStream).get(0);
                
        //Success Scenario
        assertEquals(entity.getCompany_id(), details.getCompany_id(), "company code test failed");
        assertEquals(entity.getDate(),details.getDate(), "Date check failed");
        assertEquals(entity.getExchange_id(), details.getExchange_id(), "Stock Exchange code test failed");
        assertEquals(entity.getTime(), details.getTime(), "Time inserted test failed");
        
        //Failure Scenario
        assertEquals(entity.getCompany_id(), 2, "company code test failed");
        assertEquals(entity.getDate(), LocalDate.parse("2020-06-09"), "Date check failed");
        assertEquals(entity.getExchange_id(), "NSE", "Stock Exchange code test failed");
        assertEquals(entity.getTime(),LocalTime.NOON , "Time inserted test failed");
        
    }
}
