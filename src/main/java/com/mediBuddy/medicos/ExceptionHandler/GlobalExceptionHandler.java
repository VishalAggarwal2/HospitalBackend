package com.mediBuddy.medicos.ExceptionHandler;

import com.mediBuddy.medicos.Advice.ApiResponseProject;
import com.mediBuddy.medicos.Exceptions.InvalidCreadentials;
import com.mediBuddy.medicos.Exceptions.ResourceAlreadyExist;
import com.mediBuddy.medicos.Exceptions.ResourceNotFoundException;
import com.mediBuddy.medicos.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidCreadentials.class)
    public ResponseEntity<ApiResponseProject<String>> handleInvalidCreadentialException(InvalidCreadentials ic){
        ApiResponseProject<String> response = new ApiResponseProject("Failure",ic.getMessage(),null);
return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseProject<String>> handleResourcreNotFoundException(ResourceNotFoundException ic){
        ApiResponseProject<String> response = new ApiResponseProject("Failure",ic.getMessage(),null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceAlreadyExist.class)
    public ResponseEntity<ApiResponseProject<String>> handleResourcreAlreadyExistException(ResourceAlreadyExist ic){
        ApiResponseProject<String> response = new ApiResponseProject("Failure",ic.getMessage(),null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
