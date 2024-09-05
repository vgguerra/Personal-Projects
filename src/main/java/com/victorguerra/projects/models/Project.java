package com.victorguerra.projects.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "title",unique = true)
    private String title;

    @NotBlank
    @Size(min = 50, max = 500)
    private String description;

    @NotBlank
    @Size(min = 4, max = 200)
    private String technologies;

    @Size(min = 2, max = 50)
    @Column(name = "imagem_url")
    private String imagemURL;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "git_hub_link")
    private String gitHubLink;

}
