package com.challenge.backend.note.service;

import com.challenge.backend.category.model.entity.Category;
import com.challenge.backend.category.model.persistance.CategoryRepository;
import com.challenge.backend.note.domain.model.entity.Note;
import com.challenge.backend.note.domain.persistance.NoteRepository;
import com.challenge.backend.note.domain.service.NoteService;
import com.challenge.backend.shared.exception.ResourceNotFoundException;
import com.challenge.backend.shared.exception.ResourceValidationException;
import com.challenge.backend.users.domain.model.Entity.User;
import com.challenge.backend.users.domain.persistance.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class NoteServiceImpl implements NoteService {
    private static final String ENTITY = "Note";
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final Validator validator;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository, Validator validator , CategoryRepository categoryRepository){
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.validator = validator;
    }
    @Override
    public Note getById(Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, noteId));
    }

    @Override
    public Note create(Long userId , Note request) {
        Set<ConstraintViolation<Note>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId));
        Note note = new Note();
        user.getNotes().add(note);
        note = noteRepository.save(note.withUser(user).
                withTitle(request.getTitle()).
                withContent(request.getContent()).
                withArchived(request.getArchived()));
        return noteRepository.save(note);
    }

    @Override
    public Note update(Long noteId , Note request){
        Set<ConstraintViolation<Note>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

      return noteRepository.findById(noteId).map(note -> {
          note.setTitle(request.getTitle());
          note.setContent(request.getContent());
          note.setArchived(request.getArchived());
          return noteRepository.save(note);
      }).orElseThrow(()-> new ResourceNotFoundException(ENTITY,noteId));
    }

    @Override
    public ResponseEntity<?> delete(Long noteId) {
        return noteRepository.findById(noteId).map(note -> {
            noteRepository.delete(note);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, noteId));
    }

    @Override
    @Transactional
    public Note addCategoryToNote(Long noteId , Category category){
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, noteId));
        category =categoryRepository.save(category);
        note.getCategories().add(category);
        return note;
    }
}