package com.jetdevs.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jetdevs.test.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

	List<UserEntity> findByUserName(String username);

}
