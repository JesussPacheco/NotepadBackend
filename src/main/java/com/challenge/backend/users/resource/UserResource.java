package com.challenge.backend.users.resource;

import com.challenge.backend.note.domain.model.entity.Note;
import com.challenge.backend.shared.resource.AuditModelResource;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
public class UserResource extends AuditModelResource {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Set<Note> notes;
}