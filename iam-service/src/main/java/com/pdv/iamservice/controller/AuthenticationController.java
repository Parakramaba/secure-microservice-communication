package com.pdv.iamservice.controller;

import com.pdv.iamservice.record.request.AuthRequestRecord;
import com.pdv.iamservice.record.response.AuthResponseRecord;
import com.pdv.iamservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseRecord> loginUser(@RequestBody AuthRequestRecord authRequestRecord) {
        return authenticationService.loginUser(authRequestRecord);
    }
}
