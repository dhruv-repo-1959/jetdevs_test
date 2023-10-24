package com.jetdevs.test.serviceimpl;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.jetdevs.test.dao.ExcelFileDataDao;
import com.jetdevs.test.dao.ProductDao;
import com.jetdevs.test.dto.ProductDTO;
import com.jetdevs.test.entity.ExcelFileData;
import com.jetdevs.test.entity.ProductEntity;
import com.jetdevs.test.helper.ExcelHelper;
import com.jetdevs.test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ExcelFileDataDao excelFileDataDao;

	@Override
	public void saveProductData(MultipartFile file) {

		ExcelFileData data = new ExcelFileData(file.getOriginalFilename(), file.getContentType());
		data = excelFileDataDao.save(data);
		try {
			List<JSONObject> excelData = ExcelHelper.getExcelData(file.getInputStream());
			Gson g = new Gson();
			List<ProductDTO> pm = new ArrayList<>();
			for (JSONObject j : excelData) {
				pm.add(g.fromJson(j.toString(), ProductDTO.class));
			}
			List<ProductEntity> productEntity = new ArrayList<>();
			ProductEntity pEntity = null;
			for (ProductDTO p : pm) {
				pEntity = new ProductEntity(p.getId(), p.getProductName(), p.getProductDesc(), p.getSerialNo(),
						p.getPrice(), data, null, null);
				productEntity.add(pEntity);
			}
			productDao.saveAll(productEntity);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductDTO> getFileRecordsById(Long fileId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		List<ProductEntity> findByFileId = productDao.findByFileDataFileId(fileId);
		for (ProductEntity p : findByFileId) {
			p.setReviewedBy(name);
			p.setReviewedOn(ZonedDateTime.now());
		}

		productDao.saveAll(findByFileId);

		return findByFileId.stream().map(f -> new ProductDTO(f.getProductId(), f.getProductName(), f.getProductDesc(),
				f.getSerialNumber(), f.getPrice())).toList();
	}

}
