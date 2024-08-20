package com.erkan.City.repository;


import com.erkan.City.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface UserRepository extends JpaRepository<User,Short> {
}
