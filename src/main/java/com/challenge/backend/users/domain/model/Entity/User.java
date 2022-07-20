package com.challenge.backend.users.domain.model.Entity;
import com.challenge.backend.note.domain.model.entity.Note;
import com.challenge.backend.shared.domain.model.entity.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Entity
@Table(name ="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(
            targetEntity = Note.class,
            mappedBy = "user",
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<Note> notes;
}