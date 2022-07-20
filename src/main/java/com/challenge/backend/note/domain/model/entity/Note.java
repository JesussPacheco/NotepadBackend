package com.challenge.backend.note.domain.model.entity;

import com.challenge.backend.category.model.entity.Category;
import com.challenge.backend.shared.domain.model.entity.AuditModel;
import com.challenge.backend.users.domain.model.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Entity
@Table(name = "notes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Note extends AuditModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            nullable = false
    )
    @JsonIgnore
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name ="note_category",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category>categories;

    private String Title;

    private String  Content;

    private Boolean Archived;

}