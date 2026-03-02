package com.example.uberappproject.uberapp.entities;

import com.example.uberappproject.uberapp.entities.enums.TransactionMethod;
import com.example.uberappproject.uberapp.entities.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

//    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    @OneToOne
    private Ride ride;

    @ManyToOne
    private Wallet wallet;

    private String transactionId;

    @CreationTimestamp
    private LocalDateTime timestamp;
}
