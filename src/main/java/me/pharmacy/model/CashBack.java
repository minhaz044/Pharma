package me.pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Minhaz on 1/20/2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cashback")
public class CashBack {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int cashBackId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer salesRef;
    private Double amount;
    private Date createdAt;
    private boolean is_delete=false;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }


}