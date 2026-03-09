package com.example.crud_hospital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Hospital {
    @Id
    private String cnpj;

    private String name;
    private String phoneNumber;
}
