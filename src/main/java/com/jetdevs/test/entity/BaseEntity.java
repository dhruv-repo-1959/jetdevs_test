package com.jetdevs.test.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3456660532190014194L;

	@Column(name = "created_by", updatable = false)
	@CreatedBy
	private String createdBy;

	@CreationTimestamp
	@Column(name = "created_on")
	private ZonedDateTime createdOn;

	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;

	@UpdateTimestamp
	@Column(name = "updated_on")
	private ZonedDateTime updatedOn;

	@Column(name = "enabled")
	private Boolean enabled = true;
}
