package com.gabs.errorHandling.controller;

import com.gabs.errorHandling.dto.User;
import com.gabs.errorHandling.exception.BusinessException;
import com.gabs.errorHandling.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    public ResponseEntity saveUser(@RequestBody User user){
        if(user.getEmail().isEmpty() ){
            throw new RequestException("P-599","Email is required");
        }

        if(user.getEmail().equals("test@gmail.com") ){
            throw new BusinessException("Email already exist","P300",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
