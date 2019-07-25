package com.apraware.hci.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 *
 * @author randi
 */
@Service
public class RequestValidationService {

    public ResponseEntity<?> ValidationService(BindingResult result) {
        if (result.hasErrors()) {
            var errorMap = new HashMap<String, String>();
            result.getFieldErrors().forEach((FieldError err) -> {
                errorMap.put(err.getField(), err.getDefaultMessage());
            });
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
