package com.jetdevs.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jetdevs.test.dao.ExcelFileDataDao;
import com.jetdevs.test.dto.FileDTO;
import com.jetdevs.test.entity.ExcelFileData;
import com.jetdevs.test.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private ExcelFileDataDao fileDao;

	@Override
	public List<FileDTO> getFileList() {
		List<ExcelFileData> files = fileDao.findAll();
		return files.stream().map(f -> new FileDTO(f.getFileId(), f.getFileName(), f.getFileType())).toList();
	}

	@Override
	public void deleteById(Long fileId) {
		fileDao.deleteById(fileId);
	}

}
