package com.tus.project.dto;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "EMPLOYEE_POSITION")
    private String employeePosition;
    
    @Column(name = "EMAIL")  // New field
    private String email;

    @Column(name = "JOIN_DATE")  // New field
    private LocalDate joinDate;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	// One-to-One relationship with Salary
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SALARY_ID")
    private Salary salary;

    public Employee() {
    }

    public Employee(String employeeName, String employeePosition) {
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
    }
    

    public Employee(Long employeeId, String employeeName, String employeePosition, String email, LocalDate joinDate,
			Salary salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePosition = employeePosition;
		this.email = email;
		this.joinDate = joinDate;
		this.salary = salary;
	}

	// Getters and setters

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePosition="
				+ employeePosition + ", email=" + email + ", joinDate=" + joinDate + ", salary=" + salary + "]";
	}
}
