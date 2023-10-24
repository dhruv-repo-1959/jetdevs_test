package com.jetdevs.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jetdevs.test.dto.ResponseDTO;
import com.jetdevs.test.service.FileService;

@RestController
@RequestMapping(value = "/api/file")
public class FileController {

	@Autowired
	private FileService fileService;

	@GetMapping("/get-all-files")
	public ResponseEntity<ResponseDTO> getFileList() {
		return ResponseEntity.ok().body(new ResponseDTO("List of files", fileService.getFileList()));
	}

	@DeleteMapping("/delete-file-by-id/{fileId}")
	public ResponseEntity<ResponseDTO> deleteFileById(@PathVariable("fileId") Long fileId) {
		fileService.deleteById(fileId);
		return ResponseEntity.ok(new ResponseDTO("File deleted successfully"));
	}
}
