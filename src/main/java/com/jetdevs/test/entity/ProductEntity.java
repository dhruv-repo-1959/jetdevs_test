package com.jetdevs.test.entity;

import java.time.ZonedDateTime;

import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3760180106998482537L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", updatable = false, nullable = false)
	private Long productId;

	@Column(name = "product_Name", nullable = false, length = 100)
	@Size(min = 5, max = 100)
	private String productName;

	@Column(name = "product_desc", nullable = false, length = 500)
	@Size(min = 5, max = 500)
	private String productDesc;

	@Column(name = "serial_number", nullable = false, length = 12)
	@Size(max = 12)
	private String serialNumber;

	@Column(name = "price")
	private Double price;

	@ManyToOne
	@JoinColumn(name = "file_id", foreignKey = @ForeignKey(name = "FILE_FK"))
	private ExcelFileData fileData;
	
	@LastModifiedBy
	@Column(name = "reviewed_by")
	private String reviewedBy;

	@UpdateTimestamp
	@Column(name = "reviewed_on")
	private ZonedDateTime reviewedOn;
}
