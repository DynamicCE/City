    package com.erkan.City.model;

    import jakarta.persistence.*;
    import lombok.Data;

    import java.util.List;

    @Entity
    @Table(name = "cities")
    @Data
    public
    class City {
        @Id
        private short id;

        private String name;

        @OneToMany(mappedBy = "city")
        private List<User> users;

    }
