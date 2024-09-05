package com.victorguerra.projects.controllers;

import com.victorguerra.projects.models.Project;
import com.victorguerra.projects.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
@Validated
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public List<Project> viewHomePage() {
        return projectService.findAll();
    }

    @GetMapping("/{id}")
    public Project viewProjectDetails(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping("/admin/save")
    public Project addProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @PostMapping("/admin/update/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        project.setId(id);
        return projectService.saveProject(project);
    }

    @DeleteMapping("/admin/delete/{id}")
    public Map<String, String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Project with ID " + id + " has been deleted");
        System.out.println(response);
        return response;
    }

}
