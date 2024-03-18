package com.pdv.iamservice.service;

import com.pdv.iamservice.entity.Role;
import com.pdv.iamservice.entity.User;
import com.pdv.iamservice.exception.ErrorMessages;
import com.pdv.iamservice.exception.ResourceNotFoundException;
import com.pdv.iamservice.exception.ValidationException;
import com.pdv.iamservice.record.UserRegistrationRecord;
import com.pdv.iamservice.repository.RoleRepository;
import com.pdv.iamservice.repository.UserRepository;
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

    private final PasswordEncoder bCryptPasswordEncoder;

    private final RoleRepository roleRepository;

    private static final String defaultRoleName = "ROLE_USER";

    /**
     *
     * @param  userRegistrationRecord record that contains user details for registration, not null
     * @return {@link ResponseEntity} with success message
     * @throws ValidationException if user provide invalid arguments
     * @throws ResourceNotFoundException if no such resource found
     */
    public ResponseEntity<?> registerUser(final UserRegistrationRecord userRegistrationRecord)
            throws ValidationException, ResourceNotFoundException {

        String userName = userRegistrationRecord.userName();
        if (userRepository.existsByUserName(userRegistrationRecord.userName())) {
            throw new ValidationException(ErrorMessages.USER_NAME_ALREADY_EXISTS_MSG);
        }
        Role role = roleRepository.findByName(defaultRoleName).orElseThrow(()
                        -> new ResourceNotFoundException(ErrorMessages.ROLE_NOT_FOUND_MSG));
        User user = User.builder()
                .userName(userName)
                .password(bCryptPasswordEncoder.encode(userRegistrationRecord.password()))
                .roles(List.of(role))
                .isActive(Boolean.TRUE)
                .build();
        userRepository.save(user);

        return new ResponseEntity<>("Your have registered successfully", HttpStatus.CREATED);
    }
}
