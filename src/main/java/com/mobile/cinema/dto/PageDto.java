package com.mobile.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class PageDto {
    private int pageNumber = 0;
    private int pageSize = 10;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "id";

    public Pageable getPageable() {
        return PageRequest.of(
                this.pageNumber,
                this.pageSize,
                this.sortDirection,
                this.sortBy
        );
    }
}
