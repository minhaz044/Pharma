/**
 * 
 */
package me.pharmacy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Minhaz Uddin
 *
 * Nov 16, 2019
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="expense")
public class Expense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int expenseId;
	public String expenseType;
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person expenseBy;
	public String   expenseFor;
	public String recivePerson;
	public String expenseDetail;
	public String expenseRefInfo;
	public double expenseAmount;
	public Date expenseDate;
	private Date createdAt;
	private boolean is_delete=false;
	
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	

}
