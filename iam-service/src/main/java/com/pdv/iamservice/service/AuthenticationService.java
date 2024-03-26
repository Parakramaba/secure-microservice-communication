package com.pdv.iamservice.service;

import com.pdv.iamservice.dto.CustomUserDetails;
import com.pdv.iamservice.entity.User;
import com.pdv.iamservice.exception.ErrorMessages;
import com.pdv.iamservice.exception.ResourceNotFoundException;
import com.pdv.iamservice.record.request.AuthRequestRecord;
import com.pdv.iamservice.record.response.AuthResponseRecord;
import com.pdv.iamservice.repository.UserRepository;
import com.pdv.iamservice.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("AuthenticationService")
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public ResponseEntity<AuthResponseRecord> loginUser(AuthRequestRecord authRequestRecord)
            throws ResourceNotFoundException, BadCredentialsException {

        String userName = authRequestRecord.userName();
        User user = userRepository.findByUserNameAndIsActiveTrue(authRequestRecord.userName())
                .orElseThrow(() -> new UsernameNotFoundException(
                        ErrorMessages.USER_NOT_FOUND_MSG));

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userName,
                            authRequestRecord.password()
                    )
            );
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException(ErrorMessages.CREDENTIALS_NOT_MATCH_MSG);
        }
        String jwt = jwtService.generateToken(new CustomUserDetails(user));
        AuthResponseRecord response = new AuthResponseRecord(jwt, "You have successfully logged in to your account");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
