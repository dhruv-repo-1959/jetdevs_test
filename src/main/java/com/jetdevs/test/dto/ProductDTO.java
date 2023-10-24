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
public class ProductDTO {
	@SerializedName("Id")
	private Long id;
	@SerializedName("Product Name")
	private String productName;
	@SerializedName("Product Desc")
	private String productDesc;
	@SerializedName("Serial No")
	private String serialNo;
	@SerializedName("Price")
	private Double price;
}
