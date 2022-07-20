package com.challenge.backend.category.model.entity;

import com.challenge.backend.note.domain.model.entity.Note;
import com.challenge.backend.shared.domain.model.entity.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Entity
@Table(name = "categories")
@Inheritance(strategy = InheritanceType.JOINED)
public class Category  extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Note>notes;

}