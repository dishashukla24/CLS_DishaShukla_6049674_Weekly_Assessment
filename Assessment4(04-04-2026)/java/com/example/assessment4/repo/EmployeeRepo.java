package com.example.assessment4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assessment4.entity.Employee;

public interface EmployeeRepo extends JpaRepository <Employee,Integer> {

}

