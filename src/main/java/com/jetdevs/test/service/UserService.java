package com.jetdevs.test.service;

import org.springframework.http.ResponseEntity;

import com.jetdevs.test.dto.UserDTO;

public interface UserService {

	ResponseEntity<String> saveUser(UserDTO userDTO);

}
