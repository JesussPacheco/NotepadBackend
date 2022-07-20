package com.challenge.backend.note.resources.update;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateNoteResource {
    @NotNull
    private String Title;

    @NotNull
    private String Content;

    private Boolean Archived;
}