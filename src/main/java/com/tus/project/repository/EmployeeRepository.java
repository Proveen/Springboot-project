package com.tus.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tus.project.dto.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeName(String employeeName);

    Optional<Employee> findByEmployeeNameAndEmployeePosition(String employeeName, String employeePosition);
    
    List<Employee> findByEmployeePosition(String employeePosition);
    // Add any additional query methods if needed based on new fields
    List<Employee> findBySalary_SalaryAmountGreaterThan(double amount);
    
    List<Employee> findByJoinDateBetween(LocalDate startDate, LocalDate endDate);
    
    List<Employee> findBySalary_SalaryAmountBetween(double minAmount, double maxAmount);
    
    List<Employee> findBySalary_Currency(String currency);
    
    Optional<Employee> findByEmployeeId(Long employeeId);
}
