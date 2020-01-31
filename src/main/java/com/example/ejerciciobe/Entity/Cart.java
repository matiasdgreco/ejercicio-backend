package com.example.ejerciciobe.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    private Float total;
    @Enumerated(EnumType.STRING)
    private Status status;

    protected Cart() {
    }

    public Cart(CartRequest cartRequest) {
        fullName = cartRequest.getFullName();
        email = cartRequest.getEmail();
        creationDate = new Date();
        total = (float) 0;
        status = Status.NEW;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Float getTotal() {
        return total;
    }

    public Status getStatus() {
        return status;
    }
}
