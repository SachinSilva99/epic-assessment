package com.sachin.assessmentspringboot.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StandardResponse <T>{
    private String responseStatusCode;
    private String responseMsg;
    private T content;
}
