package com.challenge.backend.note.mapping;
import com.challenge.backend.note.domain.model.entity.Note;
import com.challenge.backend.note.resources.NoteResource;
import com.challenge.backend.note.resources.create.CreateNoteResource;
import com.challenge.backend.note.resources.update.UpdateNoteResource;
import com.challenge.backend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;


public class NoteMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    public NoteResource toResource(Note model) {
        return mapper.map(model, NoteResource.class);
    }

    public Note toModel(CreateNoteResource resource) {return mapper.map(resource, Note.class);}

    public Note toModel(UpdateNoteResource resource) {
        return mapper.map(resource, Note.class);
    }
}