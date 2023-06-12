package com.example.war.repository;

import org.springframework.stereotype.Repository;
import com.example.war.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JPARepo extends JpaRepository<Registration, Integer>{

}
