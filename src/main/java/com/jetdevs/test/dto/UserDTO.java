package com.jetdevs.test.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Long userId;

	private String firstName;

	private String lastName;

	private String userName;

	private String password;

	// private List<RoleTypeDTO> roleType;

	private String roleType;

}
