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
public class ResponseDTO {

	private String message;

	private List<?> dataList;

	public ResponseDTO(String message) {
		this.message = message;
	}
}
