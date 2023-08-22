package com.bookstore.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem extends BaseEntity{

	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Order order;
	
	private int quantity;
	
	
}
