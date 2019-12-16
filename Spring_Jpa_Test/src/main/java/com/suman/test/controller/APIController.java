package com.suman.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.DataMarker;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suman.test.DTO.UserDTO;
import com.suman.test.service.APIService;

@RestController
@RequestMapping(value="/api")
public class APIController {
	@Autowired
	public APIService service;

	@RequestMapping(value="/createUser", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createUser(@RequestBody UserDTO dto) {
		try {
			System.out.println(dto);
			service.insertUser(dto.getUser_name(), dto.getPassword());
			return new ResponseEntity<String>("User Created Successfully",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("User Creation Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "Success";
	}
	
	@RequestMapping(value="/excelupload", method=RequestMethod.POST)
	public ResponseEntity<String> uploadExcelData() {
		try {
			boolean is_first = true;
			int count = 0;
			Map<Integer, ArrayList<String>> data_map = new HashMap<Integer, ArrayList<String>>();
			FileInputStream file = new FileInputStream(new File("C:\\Users\\mm0419\\Desktop\\test_data.xlsx"));
			 
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                ArrayList<String> temp = new ArrayList<String>();
                if(!is_first) {
                	while (cellIterator.hasNext()) 
                    {
                        Cell cell = cellIterator.next();
                        	switch (cell.getCellType()) 
                            {
                                case Cell.CELL_TYPE_NUMERIC:
                                	Integer i = (int)cell.getNumericCellValue();
                                    System.out.print(i.toString());
                                    temp.add(i.toString());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    System.out.print(cell.getStringCellValue());
                                    temp.add(cell.getStringCellValue());
                                    break;
                            }
                    }
                }else {
                	is_first = false;
                	continue;
                }
                data_map.put(count, temp);
                count++;
                System.out.println("");
            }
            file.close();
            service.insertDataFromExcel(data_map);
            return new ResponseEntity<String>("Uploaded Successfully",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("User Creation Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
