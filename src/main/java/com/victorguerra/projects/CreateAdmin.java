package com.victorguerra.projects;

import com.victorguerra.projects.models.Admin;
import com.victorguerra.projects.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class CreateAdmin implements CommandLineRunner {
    @Autowired
    private AdminService adminService;

    @Value("${INITIAL_ADMIN_PASSWORD}")
    private String adminPassword;

    @Override
    public void run(String... args) throws Exception {
        if(adminService.findAdminByUsername("admin") == null){
            Admin admin = new Admin();
            admin.setUsername("admin");
            admin.setPassword(adminPassword);
            admin.setRole("ADMIN");
            adminService.saveUser(admin);
        }
    }
}
