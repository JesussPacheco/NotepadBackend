package com.challenge.backend.users.resource.update;


import com.challenge.backend.note.domain.model.entity.Note;
import com.challenge.backend.shared.resource.AuditModelResource;
import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
public class UpdateUserResource extends AuditModelResource {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Set<Note> notes;
}