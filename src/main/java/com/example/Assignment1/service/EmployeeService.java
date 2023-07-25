package com.example.Assignment1.service;

import com.example.Assignment1.DTO.EmployeeIdDto;
import com.example.Assignment1.DTO.ManagerOfEmployeeRequestDto;
import com.example.Assignment1.DTO.SortingRequestDto;
import com.example.Assignment1.Exceptions.EmailAlreadyPresentException;
import com.example.Assignment1.Exceptions.InvalidIdException;
import com.example.Assignment1.Exceptions.NthLevelManagerException;
import com.example.Assignment1.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    public String addEmployee(Employee employee) throws EmailAlreadyPresentException;
    public List<Employee> getAllEmployees();
    public void deleteById(EmployeeIdDto employeeId) throws InvalidIdException;
    public void updateById(Employee employee) throws InvalidIdException;
    public Employee getNthManagerOfEmployee(ManagerOfEmployeeRequestDto managerOfEmployeeRequestDto) throws InvalidIdException, NthLevelManagerException;
    public List<Employee> getAllBySorting(SortingRequestDto sortingRequestDto);
}
