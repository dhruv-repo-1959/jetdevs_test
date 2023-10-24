package com.jetdevs.test.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jetdevs.test.dto.ResponseDTO;
import com.jetdevs.test.exception.InvalidExcelFormat;
import com.jetdevs.test.service.ProductService;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseDTO> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			Workbook workbook = WorkbookFactory.create(file.getInputStream());
			if (workbook instanceof org.apache.poi.hssf.usermodel.HSSFWorkbook) {
				productService.saveProductData(file);
			} else if (workbook instanceof org.apache.poi.xssf.usermodel.XSSFWorkbook) {
				productService.saveProductData(file);
			} else {
				throw new InvalidExcelFormat("Unknown Excel Format");
			}
			workbook.close();
		} catch (Exception e) {
			throw new InvalidExcelFormat("Upload valid excel file");
		}
		return ResponseEntity.ok(new ResponseDTO("File uploaded successfully"));

	}

	@GetMapping("/get-file-by-id/{fileId}")
	public ResponseEntity<ResponseDTO> getFileRecordsById(@PathVariable("fileId") Long fileId) {
		return ResponseEntity.ok().body(new ResponseDTO("List of records:", productService.getFileRecordsById(fileId)));
	}
}
