package me.pharmacy.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sales")
public class Sales {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sales_id;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Medicine product;
	private float comision;
	private int quantity;
	private boolean is_delete=false;

}