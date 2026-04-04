package com.example.assessment4.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_management")
public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer empId;

	    private String empName;
	    private Double empSal;
	    private LocalDate empDoj;
	    private String deptName;
	    
	    
	    public Employee() {
	    	
	    }
	    
		public Employee(Integer empId, String empName, Double empSal, LocalDate empDoj, String deptName) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empSal = empSal;
			this.empDoj = empDoj;
			this.deptName = deptName;
		}
		public Integer getEmpId() {
			return empId;
		}
		public void setEmpId(Integer empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public Double getEmpSal() {
			return empSal;
		}
		public void setEmpSal(Double empSal) {
			this.empSal = empSal;
		}
		public LocalDate getEmpDoj() {
			return empDoj;
		}
		public void setEmpDoj(LocalDate empDoj) {
			this.empDoj = empDoj;
		}
		public String getDeptName() {
			return deptName;
		}
		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empDoj=" + empDoj
					+ ", deptName=" + deptName + "]";
		}

	    

	}


