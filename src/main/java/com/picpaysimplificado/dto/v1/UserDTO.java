package com.picpaysimplificado.dto.v1;

import com.picpaysimplificado.domain.enums.UserType;
import com.picpaysimplificado.domain.model.User;

import java.math.BigDecimal;
import java.util.Objects;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String document;
    private BigDecimal balance;
    private String email;
    private String password;
    private UserType userType;

    public UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public UserDTO(User user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.document = user.getDocument();
        this.balance = user.getBalance();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.userType = user.getUserType();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(firstName, userDTO.firstName) && Objects.equals(lastName, userDTO.lastName) && Objects.equals(document, userDTO.document) && Objects.equals(balance, userDTO.balance) && Objects.equals(email, userDTO.email) && Objects.equals(password, userDTO.password) && userType == userDTO.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, document, balance, email, password, userType);
    }
}
