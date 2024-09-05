package com.victorguerra.projects.repositories;

import com.victorguerra.projects.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
