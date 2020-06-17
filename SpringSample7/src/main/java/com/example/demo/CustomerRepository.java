package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to automatically create a CRUD to the DB
 * CRUD: "Create", "Read", "Update", "Delete"
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
