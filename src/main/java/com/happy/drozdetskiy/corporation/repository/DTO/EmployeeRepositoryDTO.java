package com.happy.drozdetskiy.corporation.repository.DTO;

public class EmployeeRepositoryDTO {

    private final int id;
    private final String name;
    private final String surname;
    private final String department;
    private final int salary;

    public EmployeeRepositoryDTO(int id, String name, String surname, String department, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}