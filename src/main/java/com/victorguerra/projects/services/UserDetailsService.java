package com.victorguerra.projects.services;

import com.victorguerra.projects.models.Admin;
import com.victorguerra.projects.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = this.adminRepository.findAdminByUsername(username);

        if (admin == null) {
            throw new UsernameNotFoundException("Admin with username \"" + username + "\" not found");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(admin.getUsername())
                .password(admin.getPassword())
                .authorities("ROLE_ADMIN") // Simplificado
                .build();
    }
}
