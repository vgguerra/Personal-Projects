package com.victorguerra.projects.services;

import com.victorguerra.projects.models.Admin;
import com.victorguerra.projects.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

        try {
            return org.springframework.security.core.userdetails.User.withUsername(admin.getUsername()).password(admin.getPassword()).authorities(new SimpleGrantedAuthority("ROLE_ADMIN")).build();
        }
        catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Admin whith username \" + username + \" not found");
        }

    }
}
