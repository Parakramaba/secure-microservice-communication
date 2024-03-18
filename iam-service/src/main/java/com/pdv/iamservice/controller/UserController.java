package com.pdv.iamservice.controller;

import com.pdv.iamservice.record.UserRegistrationRecord;
import com.pdv.iamservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@AllArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(final @RequestBody @Valid UserRegistrationRecord userRegistrationRecord) {
        return userService.registerUser(userRegistrationRecord);
    }
}
