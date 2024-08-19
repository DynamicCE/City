package com.erkan.City.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cities")
@Data
public
class City {
    @Id
    private Long id;

    private String name;
}
