package com.jetdevs.test.entity;

import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
	/**
	* 
	*/
	private static final long serialVersionUID = 8736171195673334607L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false, nullable = false)
	private Long userId;

	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;

	@Column(name = "user_name", nullable = false)
	@Size(min = 5, max = 100)
	private String userName;

	@Column(name = "password", nullable = false)
	@Size(min = 8, max = 32)
	private String password;

	/*
	 * @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id",
	 * referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name =
	 * "role_id", referencedColumnName = "role_id")) private Set<RoleTypeEntity>
	 * roleType = new HashSet<>();
	 */

	@Column(name = "role_type")
	private String roleType;

	public UserEntity(String firstName, String lastName, @Size(min = 5, max = 100) String userName,
			@Size(min = 8, max = 32) String password, String roleType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.roleType = roleType;
	}

}
