package com.jetdevs.test.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jetdevs.test.dto.ProductDTO;

public interface ProductService {

	void saveProductData(MultipartFile file);

	List<ProductDTO> getFileRecordsById(Long fileId);

}
