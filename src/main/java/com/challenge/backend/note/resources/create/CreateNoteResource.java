package com.challenge.backend.note.resources.create;

import lombok.*;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
public class CreateNoteResource {
    @NotNull
    private String Title;

    @NotNull
    private String Content;

    private Boolean Archived;
}