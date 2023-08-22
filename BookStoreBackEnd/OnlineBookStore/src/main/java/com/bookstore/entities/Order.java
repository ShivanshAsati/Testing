package com.bookstore.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order extends BaseEntity{
	
	@ManyToOne
	private User user; 
	
	@Column(name = "order_date")
	private LocalDateTime orderDate;
	
	@Column(name = "delivery_date")
	private LocalDateTime deliveryDate;
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "status")
	private Status status;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> orderItems = new ArrayList<>();
	
	
}
