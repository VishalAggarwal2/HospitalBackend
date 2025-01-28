package com.mediBuddy.medicos.Advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiResponseProject<T> {
    private String status;
    private String message;
    private T data;

}
