package me.pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by minhaz on 1/26/2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="due_pay_histry")
public class DuePayHistry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private double remainingAmount;
    @ManyToOne
    @JoinColumn(name = "customerInfoId")
    private CustomerInfo customerInfoId;

    private Date createdAt;
    private boolean is_delete = false;

    public transient int userId;
    @PrePersist
    protected void onCreate() {createdAt = new Date();}
}