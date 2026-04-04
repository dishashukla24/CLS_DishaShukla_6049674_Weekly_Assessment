package com.example.assessment4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assessment4.dto.EmployeeDTO;
import com.example.assessment4.entity.Employee;
import com.example.assessment4.repo.EmployeeRepo;


@Service
public class EmpService {

    @Autowired
    private EmployeeRepo repo;

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public EmployeeDTO getById(int id) {
        Employee emp = repo.findById(id).orElseThrow();
        EmployeeDTO dto = new EmployeeDTO();
        dto.setDeptName(emp.getDeptName());
        dto.setEmpDoj(emp.getEmpDoj());
        dto.setEmpId(emp.getEmpId());
        dto.setEmpName(emp.getEmpName());
        dto.setEmpSal(emp.getEmpSal());
        return dto;
    }

    public void update(EmployeeDTO dto) {
    	Employee emp = new Employee();
        emp.setDeptName(dto.getDeptName());
        emp.setEmpDoj(dto.getEmpDoj());
        emp.setEmpId(dto.getEmpId());
        emp.setEmpName(dto.getEmpName());
        emp.setEmpSal(dto.getEmpSal());
        repo.save(emp);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}