package com.example.reto1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "first_lastname")
    private String firstLastName;

    @Column(name = "second_lastname")
    private String secondLastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "document_type")
    @Check(constraints = "document_type IN ('C', 'P')")
    @Pattern(regexp = "[CP]+")
    private String docType;

    @Column(name = "document_number")
    private String docNumber;

}
