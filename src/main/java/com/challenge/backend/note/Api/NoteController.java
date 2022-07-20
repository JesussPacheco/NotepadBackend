package com.challenge.backend.note.Api;


import com.challenge.backend.note.domain.service.NoteService;
import com.challenge.backend.note.mapping.NoteMapper;
import com.challenge.backend.note.resources.NoteResource;
import com.challenge.backend.note.resources.create.CreateNoteResource;
import com.challenge.backend.note.resources.update.UpdateNoteResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/note")
@CrossOrigin
public class NoteController {
    private final NoteService noteService;
    private final NoteMapper noteMapper;
    public NoteController(NoteService noteService,NoteMapper noteMapper ){
        this.noteService = noteService;
        this.noteMapper = noteMapper;
    }
    @GetMapping("{noteId}")
    public NoteResource getNoteById(@PathVariable Long noteId) {
        return noteMapper.toResource(noteService.getById(noteId));
    }

    @PostMapping()
    public NoteResource createNote(@RequestParam(name = "userId") Long userId,
                                           @Valid @RequestBody CreateNoteResource request) {
        return noteMapper.toResource(noteService.create(userId, noteMapper.toModel(request)));
    }

    @PutMapping("{noteId}")
    public NoteResource updateNote(@PathVariable Long noteId,
                                           @Valid @RequestBody UpdateNoteResource request) {
        return noteMapper.toResource(noteService.update(noteId, noteMapper.toModel(request)));
    }

    @DeleteMapping("{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable Long noteId) {
        return noteService.delete(noteId);
    }
}