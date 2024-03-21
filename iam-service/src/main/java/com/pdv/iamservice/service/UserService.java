package com.pdv.iamservice.service;

import com.pdv.iamservice.dto.CustomUserDetails;
import com.pdv.iamservice.entity.Role;
import com.pdv.iamservice.entity.User;
import com.pdv.iamservice.exception.ErrorMessages;
import com.pdv.iamservice.exception.ResourceNotFoundException;
import com.pdv.iamservice.exception.ValidationException;
import com.pdv.iamservice.record.request.UserRegistrationRecord;
import com.pdv.iamservice.record.response.AuthResponseRecord;
import com.pdv.iamservice.repository.RoleRepository;
import com.pdv.iamservice.repository.UserRepository;
import com.pdv.iamservice.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder bCryptPasswordEncoder;

    private final JwtService jwtService;

    private static final String defaultRoleName = "ROLE_USER";

    /**
     * This registers a user and returns a generated JWT.
     * @param  userRegistrationRecord record that contains user details for registration, not null
     * @return {@link ResponseEntity} with success message
     * @throws ValidationException if user provide invalid arguments
     * @throws ResourceNotFoundException if no such resource found
     */
    public ResponseEntity<?> registerUser(UserRegistrationRecord userRegistrationRecord)
            throws ValidationException, ResourceNotFoundException {

        if (userRepository.existsByUserName(userRegistrationRecord.userName())) {
            throw new ValidationException(ErrorMessages.USER_NAME_ALREADY_EXISTS_MSG);
        }
        User user = setUserDetails(userRegistrationRecord);
        userRepository.save(user);

        String jwt = jwtService.generateToken(new CustomUserDetails(user));
        AuthResponseRecord response = new AuthResponseRecord(jwt, "You have registered successfully");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    private User setUserDetails(UserRegistrationRecord userRegistrationRecord) {

        Role defaultRole = roleRepository.findByName(defaultRoleName).orElseThrow(()
                -> new ResourceNotFoundException(ErrorMessages.ROLE_NOT_FOUND_MSG));

        return User.builder()
                .userName(userRegistrationRecord.userName())
                .password(bCryptPasswordEncoder.encode(userRegistrationRecord.password()))
                .roles(List.of(defaultRole))
                .isActive(Boolean.TRUE)
                .build();
    }
}
