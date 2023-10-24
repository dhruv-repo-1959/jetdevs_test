package com.jetdevs.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleTypeDTO {

	private Long roleId;

	private String roleType;

	public RoleTypeDTO(String roleType) {
		super();
		this.roleType = roleType;
	}

}
