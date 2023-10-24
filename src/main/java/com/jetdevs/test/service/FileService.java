package com.jetdevs.test.service;

import java.util.List;

import com.jetdevs.test.dto.FileDTO;

public interface FileService {

	List<FileDTO> getFileList();

	void deleteById(Long fileId);

}
