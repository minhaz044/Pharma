/**
 * 
 */
package me.pharmacy.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Minhaz Uddin
 *
 * Sep 6, 2019
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="buy")
public class Buy {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer buyId;
	private String toWhom;
	private String forWhom;
	private String Reference;
	private String comment;
	private String accountAble;
	private Double amount;
	
}
