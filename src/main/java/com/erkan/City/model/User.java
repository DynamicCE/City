package com.erkan.City.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public
class User {
    @Id
    private short identityNo;

    private String name;

    private String surName;

    @ManyToOne
    @JoinColumn( name = "city_id")
    private City city;
}
