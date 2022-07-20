package com.challenge.backend.note.resources;

import com.challenge.backend.shared.resource.AuditModelResource;
import com.challenge.backend.users.domain.model.Entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
public class NoteResource  extends AuditModelResource {
    private Long id;
    private String Title;
    private String  Content;
    private Boolean Archived;
    private Long userId;
}