package com.tus.project.controller;

import com.tus.project.dto.Employee;
import com.tus.project.dto.Salary;
import com.tus.project.exception.ResourceNotFoundException;
import com.tus.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class DemoController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index() {
        return "<h1>Employee Salaries Microservice</h1>";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent())
            return ResponseEntity.ok().body(employee.get());
        else
            throw new ResourceNotFoundException("Employee not found :: " + id);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return ResponseEntity.ok("Employee with ID " + employeeId + " was deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee with ID " + employeeId + " not found");
        }
    }
    
    

    @GetMapping("/employees/byName/{employeeName}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable(value = "employeeName") String employeeName)
            throws ResourceNotFoundException {
        Optional<Employee> employee = employeeRepository.findByEmployeeName(employeeName);
        if (employee.isPresent())
            return ResponseEntity.ok().body(employee.get());
        else
            throw new ResourceNotFoundException("Employee not found with name :: " + employeeName);
    }

    @GetMapping("/employees/byNameAndPosition/{employeeName}/{employeePosition}")
    public ResponseEntity<Employee> getEmployeeByNameAndPosition(
            @PathVariable(value = "employeeName") String employeeName,
            @PathVariable(value = "employeePosition") String employeePosition) throws ResourceNotFoundException {
        Optional<Employee> employee = employeeRepository.findByEmployeeNameAndEmployeePosition(employeeName, employeePosition);
        if (employee.isPresent())
            return ResponseEntity.ok().body(employee.get());
        else
            throw new ResourceNotFoundException("Employee not found with name and position :: " + employeeName + ", " + employeePosition);
    }

    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        // Assuming you have a separate repository for Salary entities
        // and a method similar to findAll in EmployeeRepository
        // For simplicity, you can adapt it based on your actual structure
        // For instance, you can have a separate SalaryRepository
        return null;
    }
    
 // Endpoint to get all employees with a certain position
    @GetMapping("/employees/byPosition/{position}")
    public List<Employee> getEmployeesByPosition(@PathVariable String position) {
        return employeeRepository.findByEmployeePosition(position);
    }
    
 // Endpoint to update an employee's position
    @PutMapping("/employees/updatePosition/{id}/{newPosition}")
    public ResponseEntity<Employee> updateEmployeePosition(
            @PathVariable Long id,
            @PathVariable String newPosition) throws ResourceNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setEmployeePosition(newPosition);
            employeeRepository.save(employee);
            return ResponseEntity.ok().body(employee);
        } else {
            throw new ResourceNotFoundException("Employee not found :: " + id);
        }
    }
    
    @GetMapping("/employees/salaryRange/{minAmount}/{maxAmount}")
    public List<Employee> getEmployeesBySalaryRange(
            @PathVariable double minAmount,
            @PathVariable double maxAmount) {
        // Assuming you have a salary property in the Employee entity
        return employeeRepository.findBySalary_SalaryAmountBetween(minAmount, maxAmount);
    }
    
 // Endpoint to find all employees earning in GBP
    @GetMapping("/employees/earningInGBP")
    public List<Employee> getEmployeesEarningInGBP() {
        return employeeRepository.findBySalary_Currency("GBP");
    }
    
 // Endpoint to update the salary of an employee by employee ID
    @PutMapping("/employees/updateSalary/{id}/{newSalary}")
    public ResponseEntity<Employee> updateEmployeeSalary(
            @PathVariable Long id,
            @PathVariable double newSalary) throws ResourceNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findByEmployeeId(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            
            // Assuming you have a Salary entity associated with Employee
            Salary salary = employee.getSalary();
            if (salary != null) {
                salary.setSalaryAmount(newSalary);
                employeeRepository.save(employee);
                return ResponseEntity.ok().body(employee);
            } else {
                throw new ResourceNotFoundException("Salary information not found for Employee ID :: " + id);
            }
        } else {
            throw new ResourceNotFoundException("Employee not found :: " + id);
        }
    }

    
 // Endpoint to get all employees with a salary above a certain amount
    @GetMapping("/employees/salaryAbove/{amount}")
    public List<Employee> getEmployeesWithSalaryAbove(@PathVariable double amount) {
        return employeeRepository.findBySalary_SalaryAmountGreaterThan(amount);
    }

    // Other salary-related endpoints can be added based on your requirements
 // Endpoint to find all employees who joined in 02-2022
    @GetMapping("/employees/joinedInFeb2022")
    public List<Employee> getEmployeesJoinedInFeb2022() {
        LocalDate startDate = LocalDate.of(2022, 2, 1); // Start of February 2022
        LocalDate endDate = LocalDate.of(2022, 2, 28);  // End of February 2022
        return employeeRepository.findByJoinDateBetween(startDate, endDate);
    }

    
}
