package com.cleansoap.coursework.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id // Primary key
    private Integer clientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private Boolean blockingStatus;
    private Boolean superuserStatus;




    public Client() {
    }

    public Client(Integer clientId, String firstName, String lastName, String phoneNumber, String email, String password, Boolean blockingStatus, Boolean superUserStatus) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.blockingStatus = blockingStatus;
        this.superuserStatus = superUserStatus;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Boolean getBlockingStatus() {
        return blockingStatus;
    }

    public void setBlockingStatus(Boolean blockingStatus) {
        this.blockingStatus = blockingStatus;
    }

    public Boolean getSuperuserStatus() {
        return superuserStatus;
    }

    public void setSuperuserStatus(Boolean superUserStatus) {
        this.superuserStatus = superUserStatus;
    }

}
