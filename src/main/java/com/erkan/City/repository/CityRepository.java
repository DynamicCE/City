package com.erkan.City.repository;

import com.erkan.City.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface CityRepository extends JpaRepository<City,Long> {
}
