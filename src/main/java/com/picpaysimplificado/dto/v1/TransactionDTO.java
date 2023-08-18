package com.picpaysimplificado.dto.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class TransactionDTO implements Serializable {
    private BigDecimal value;
    private Long senderId;
    private Long receiverId;

    public TransactionDTO(BigDecimal value, Long senderId, Long receiverId) {
        this.value = value;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDTO that = (TransactionDTO) o;
        return Objects.equals(value, that.value) && Objects.equals(senderId, that.senderId) && Objects.equals(receiverId, that.receiverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, senderId, receiverId);
    }
}
