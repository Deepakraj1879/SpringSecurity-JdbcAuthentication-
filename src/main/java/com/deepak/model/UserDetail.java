package com.deepak.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_detail")
public class UserDetail {
	
	@Id
	private Integer id;
	private String name;
	private String password;
	private String roles;

}
