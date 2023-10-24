package com.jetdevs.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jetdevs.test.entity.ExcelFileData;

@Repository
public interface ExcelFileDataDao extends JpaRepository<ExcelFileData, Long> {

}
