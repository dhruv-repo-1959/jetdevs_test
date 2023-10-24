package com.jetdevs.test.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.jetdevs.test.constants.GeneralConstants;

public class ExcelHelper {

	public static boolean hasExcelFormat(MultipartFile file) {
		return !GeneralConstants.TYPE.equals(file.getContentType());
	}

	public static List<JSONObject> getExcelData(InputStream inputStream) {
		List<JSONObject> dataList = new ArrayList<>();
		DataFormatter fmt = new DataFormatter();
		try {
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet workSheet = workBook.getSheetAt(0);
			XSSFRow header = workSheet.getRow(1);
			for (int i = 2; i < workSheet.getPhysicalNumberOfRows(); i++) {
				XSSFRow row = workSheet.getRow(i);
				HashMap<String, String> map = new HashMap<>();
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					String columnName = header.getCell(j).toString();
					String columnValue = fmt.formatCellValue(row.getCell(j));
					map.put(columnName, columnValue);
				}
				JSONObject rowJsonObject = new JSONObject(map);
				dataList.add(rowJsonObject);
			}
			workBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;
	}

}
