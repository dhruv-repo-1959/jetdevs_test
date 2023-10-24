package com.jetdevs.test.dto;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDTO {

	@SerializedName("Id")
	private Long id;
	@SerializedName("File Name")
	private String fileName;
	@SerializedName("File Type")
	private String fileType;
}
