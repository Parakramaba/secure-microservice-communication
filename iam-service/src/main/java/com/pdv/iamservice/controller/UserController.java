package com.pdv.iamservice.controller;

import com.pdv.iamservice.record.request.UserRegistrationRecord;
import com.pdv.iamservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRegistrationRecord userRegistrationRecord) {
        return userService.registerUser(userRegistrationRecord);
    }
}
