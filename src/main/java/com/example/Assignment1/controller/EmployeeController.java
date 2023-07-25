package com.example.Assignment1.controller;

import com.example.Assignment1.DTO.EmployeeIdDto;
import com.example.Assignment1.DTO.ManagerOfEmployeeRequestDto;
import com.example.Assignment1.DTO.SortingRequestDto;
import com.example.Assignment1.Exceptions.EmailAlreadyPresentException;
import com.example.Assignment1.Exceptions.InvalidIdException;
import com.example.Assignment1.Exceptions.NthLevelManagerException;
import com.example.Assignment1.entity.Employee;
import com.example.Assignment1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        try{
            String employeeId = employeeService.addEmployee(employee);
            return new ResponseEntity<>(employeeId, HttpStatus.CREATED);
        }
        catch(EmailAlreadyPresentException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestBody EmployeeIdDto employeeId){
        try{
            employeeService.deleteById(employeeId);
            return new ResponseEntity<>("Employee deleted successfully",HttpStatus.OK);
        }
        catch (InvalidIdException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateById(@RequestBody Employee employee){
        try{
            employeeService.updateById(employee);
            return new ResponseEntity<>("Employee has been updated successfully", HttpStatus.CREATED);
        }
        catch (InvalidIdException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getManager")
    public ResponseEntity getNthManagerOfEmployee(@RequestBody ManagerOfEmployeeRequestDto managerOfEmployeeRequestDto){
        try{
            Employee manager = employeeService.getNthManagerOfEmployee(managerOfEmployeeRequestDto);
            return new ResponseEntity<>(manager, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllBySorting")
    public List<Employee> getAllBySorting(@RequestBody SortingRequestDto sortingRequestDto) {
        return employeeService.getAllBySorting(sortingRequestDto);
    }

}
