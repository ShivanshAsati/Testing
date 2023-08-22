package com.bookstore.entities;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cart extends BaseEntity{
	
	@OneToOne(fetch = FetchType.LAZY) 	// cascade ????
//	@MapsId
	@JoinColumn(name = "user_id", nullable = false)	
	private User user;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)	// not shown in db
	private Set<CartItem> cartItems = new HashSet<>();
	
	@Column(name = "total_price")
	private double totalPrice;
	
}
