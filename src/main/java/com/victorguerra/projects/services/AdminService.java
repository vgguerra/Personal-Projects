package com.victorguerra.projects.services;

import com.victorguerra.projects.models.Admin;
import com.victorguerra.projects.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(Admin admin) {
        // Codifica a senha antes de salvar
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }

    public Admin findAdminByUsername(String username) {
        return adminRepository.findAdminByUsername(username);
    }


}
