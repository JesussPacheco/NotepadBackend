package com.challenge.backend.note.domain.service;

import com.challenge.backend.category.model.entity.Category;
import com.challenge.backend.note.domain.model.entity.Note;
import org.springframework.http.ResponseEntity;

public interface NoteService {
    Note getById(Long noteId);
    Note create(Long userId, Note request);
    Note update(Long noteId, Note request);
    Note addCategorytoNote(Long noteId , Category category);
    ResponseEntity<?> delete(Long noteId);
}