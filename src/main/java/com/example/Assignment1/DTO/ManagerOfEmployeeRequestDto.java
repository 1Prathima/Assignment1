package com.example.Assignment1.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ManagerOfEmployeeRequestDto {
    private String employeeId;
    private int n;

}
