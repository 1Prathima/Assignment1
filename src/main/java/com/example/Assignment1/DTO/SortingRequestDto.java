package com.example.Assignment1.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SortingRequestDto {
    private int pageNumber;
    private int pageSize;
    private String sortBy;
}
