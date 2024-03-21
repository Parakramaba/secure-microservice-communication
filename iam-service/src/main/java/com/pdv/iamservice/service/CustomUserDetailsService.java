package com.pdv.iamservice.service;

import com.pdv.iamservice.dto.CustomUserDetails;
import com.pdv.iamservice.entity.User;
import com.pdv.iamservice.exception.ErrorMessages;
import com.pdv.iamservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This provides implementation for UserDetailsService.
 */
@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserNameAndIsActiveTrue(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(ErrorMessages.USER_NOT_FOUND_MSG));
        return user.map(CustomUserDetails::new).get();
    }
}
