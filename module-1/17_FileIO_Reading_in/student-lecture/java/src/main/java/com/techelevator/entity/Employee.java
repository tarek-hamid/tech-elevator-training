package com.techelevator.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee extends Person implements Movable {

    private int empNo;

    private String role;

    private BigDecimal salary;

    public Employee() {
    }


    public Employee(String firstName, String lastName, String email, int empNo, String role, BigDecimal salary) {
        super(firstName, lastName, email);
        this.empNo = empNo;
        this.role = role;
        this.salary = salary;
    }

    /*  Getters and Setters:
        Property definitions for the Java Bean Spec
        Property name - drop the get or set and go lower case on first letter
        Examples: empNo, role, salary
     */
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return empNo == employee.empNo &&
                Objects.equals(role, employee.role) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), empNo, role, salary);
    }

    @Override
    public String toString() {
        return "Employee{" + " : " + super.toString() +
                " empNo=" + empNo +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public String startMoving() {
        return "Employee is started...";
    }

    @Override
    public String move() {
        return "Employee is moving...";
    }

    @Override
    public String stopMoving() {
        return "Employee stopped moving...";
    }
}
