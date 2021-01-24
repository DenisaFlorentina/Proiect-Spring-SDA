package com.diainstalwater.diaInstalWater.service;

import com.diainstalwater.diaInstalWater.model.User;
import com.diainstalwater.diaInstalWater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
