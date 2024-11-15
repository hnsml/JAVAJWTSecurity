package com.example.poemsspringsecuritydemo.config;

import com.example.poemsspringsecuritydemo.entities.ERole;
import com.example.poemsspringsecuritydemo.entities.Role;
import com.example.poemsspringsecuritydemo.repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseInitializer {

    @Autowired
    RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        for (ERole eRole : ERole.values()) {
            Optional<Role> role = roleRepository.findByName(eRole);
            if (role.isEmpty()) {
                roleRepository.save(new Role(eRole));
            }
        }
    }
}
