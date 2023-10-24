package com.jetdevs.test.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jetdevs.test.dao.UserDao;
import com.jetdevs.test.dto.UserDTO;
import com.jetdevs.test.entity.UserEntity;
import com.jetdevs.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<String> saveUser(UserDTO userDTO) {
		UserEntity savedUser = null;
		ResponseEntity<String> response = null;
		try {
			String hashPassword = passwordEncoder.encode(userDTO.getPassword());
			userDTO.setPassword(hashPassword);
			// for (RoleTypeDTO roleType : userDTO.getRoleType()) {
//			if (!roleTypeDao.findByRoleType(userDTO.getRoleType()).isPresent()) {
//				throw new RecordNotFoundException("Role does not exits:- " + userDTO.getRoleType());
//			}
			// }
			UserEntity userEntity = new UserEntity(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getUserName(),
					hashPassword, userDTO.getRoleType());
			savedUser = userDao.save(userEntity);
			if (savedUser.getUserId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED)
						.body("Given user details are successfully registered");
			}
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured due to " + e.getMessage());
		}
		return response;
	}

}
