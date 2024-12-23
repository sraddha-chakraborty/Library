package com.books.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.library.tables.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long>{

	public Employees findEmployeesByEmpName(String empName);
}
