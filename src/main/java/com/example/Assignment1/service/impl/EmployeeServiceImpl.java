package com.example.Assignment1.service.impl;

import com.example.Assignment1.DTO.EmployeeIdDto;
import com.example.Assignment1.DTO.ManagerOfEmployeeRequestDto;
import com.example.Assignment1.DTO.SortingRequestDto;
import com.example.Assignment1.Enums.SortBy;
import com.example.Assignment1.Exceptions.EmailAlreadyPresentException;
import com.example.Assignment1.Exceptions.InvalidIdException;
import com.example.Assignment1.Exceptions.NthLevelManagerException;
import com.example.Assignment1.entity.Employee;
import com.example.Assignment1.repository.EmployeeRepository;
import com.example.Assignment1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public String addEmployee(Employee employee) throws EmailAlreadyPresentException {
        if(employeeRepository.findByEmail(employee.getEmail()) != null){
            throw new EmailAlreadyPresentException("This email id is already registered");
        }

        Employee employee1 = new Employee();
        employee1.setEmployeeName(employee.getEmployeeName());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setEmail(employee.getEmail());
        employee1.setReportsTo(employee.getReportsTo());
        employee1.setProfileImage(employee.getProfileImage());
        employee1.setId(String.valueOf(UUID.randomUUID()));
        employeeRepository.save(employee1);

//        sending mail
        SimpleMailMessage message = new SimpleMailMessage();  //class that is used to send mails
        message.setFrom("prat226999@gmail.com");
        Employee employee2 = employeeRepository.findById(employee1.getReportsTo()).get();
        message.setTo(employee2.getEmail());
        message.setSubject("Employee Successfully Added");
        message.setText( employee1.getEmployeeName()+ " will now work under you. Mobile number is " + employee1.getPhoneNumber() + " and email is "+ employee1.getEmail());
        emailSender.send(message);

        return employee1.getId();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(EmployeeIdDto employeeId) throws InvalidIdException {
        if(employeeRepository.findById(employeeId.getId()).get() == null){
            throw new InvalidIdException("Invalid Id");
        }
        employeeRepository.deleteById(employeeId.getId());
    }

    @Override
    public void updateById(Employee employee) throws InvalidIdException {
        Employee employee1 = employeeRepository.findById(employee.getId()).get();
        if(employee1 == null){
            throw new InvalidIdException("Invalid Id");
        }
        employee1.setEmployeeName(employee.getEmployeeName());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setEmail(employee.getEmail());
        employee1.setReportsTo(employee.getReportsTo());
        employee1.setProfileImage(employee.getProfileImage());

        employeeRepository.save(employee1);
    }

    @Override
    public Employee getNthManagerOfEmployee(ManagerOfEmployeeRequestDto managerOfEmployeeRequestDto) throws InvalidIdException, NthLevelManagerException {
        Employee employee = employeeRepository.findById(managerOfEmployeeRequestDto.getEmployeeId()).get();
        if(employee == null){
            throw new InvalidIdException("Employee Id is invalid.");
        }
        int n = managerOfEmployeeRequestDto.getN();

        Employee manager = null;
        String managerId = null;

        try {
            if (n == 1) {
                managerId = employee.getReportsTo();
                manager = employeeRepository.findById(managerId).get();
                return manager;
            } else {
                while (n > 0) {
                    managerId = employee.getReportsTo();
                    manager = employeeRepository.findById(managerId).get();
                    employee = manager;
                    n--;
                }
            }
        }
        catch (Exception e){
            throw new NthLevelManagerException("Nth level manager does not exist!");
        }
        return manager;
    }


    @Override
    public List<Employee> getAllBySorting(SortingRequestDto sortingRequestDto) {
        int pageNumber = sortingRequestDto.getPageNumber();
        int pageSize = sortingRequestDto.getPageSize();
        String sortBy = sortingRequestDto.getSortBy();

        Sort.Order order;
        if (sortBy.equals(SortBy.EMAIL.toString())) {
            order = Sort.Order.by("email");
        } else {
            order = Sort.Order.by("name");
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(order));

        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        List<Employee> employees = employeePage.getContent();

        return employees;
    }
}
