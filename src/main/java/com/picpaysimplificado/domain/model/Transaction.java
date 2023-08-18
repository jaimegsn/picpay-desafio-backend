package com.picpaysimplificado.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name="transaction")
@Table
public class Transaction {

    public Transaction(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name="receiver_id", nullable = false)
    private User receiver;
    @Column(name = "time_stamp",nullable = false)
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, sender, receiver, timestamp);
    }
}
