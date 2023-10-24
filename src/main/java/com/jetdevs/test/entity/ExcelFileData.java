package com.jetdevs.test.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "file_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcelFileData extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6796991236446842311L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id", updatable = false, nullable = false)
	private Long fileId;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "file_type")
	private String fileType;

	@OneToMany(mappedBy = "fileData", cascade = CascadeType.ALL)
	private List<ProductEntity> products;

	public ExcelFileData(String fileName, String fileType) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
	}

}
