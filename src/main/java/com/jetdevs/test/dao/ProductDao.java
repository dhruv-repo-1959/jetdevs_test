package com.jetdevs.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jetdevs.test.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByFileDataFileId(Long fileId);

}
