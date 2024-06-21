package com.example.webtest.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.Email;

@Data
@Entity
@Table

public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    private int experience;

    @Column(unique = true)
    @Email(message = "Please enter a valid email address.")
    @NotNull
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    @NotNull
    private role roleId;

    // Getters and setters omitted for brevity
}
