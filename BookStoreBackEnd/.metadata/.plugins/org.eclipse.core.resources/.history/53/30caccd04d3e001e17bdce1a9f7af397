package com.bookstore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User extends BaseEntity{
	
	@Column(name = "first_name", length = 40)
	private String firstName;
	
	@Column(name = "last_name", length = 40)
	private String lastName;
	
	@Column(name = "email", length = 40, unique = true)
	private String email;
	
	@Column(name = "mobile", length = 40)
	private String mobile;
	
	@Column(name = "password", length = 40)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role",length = 20, columnDefinition = "varchar(20) default 'USER'")
	private RoleType role;
	
	@OneToOne(cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@JsonIgnore //NOT SURE
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Review> reviews=new ArrayList<>();
	
//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "cart_id")
//	private Cart cart;
}
