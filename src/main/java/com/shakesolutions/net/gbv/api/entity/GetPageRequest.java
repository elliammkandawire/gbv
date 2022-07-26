package com.shakesolutions.net.gbv.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPageRequest {
    private int currentPage;
    private int recordsPerPage;
    public GetPageRequest(){
        currentPage=0;
    }
}