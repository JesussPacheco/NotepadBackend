package com.challenge.backend.category.service;

import com.challenge.backend.category.model.entity.Category;
import com.challenge.backend.category.model.persistance.CategoryRepository;
import com.challenge.backend.category.model.service.CategoryService;
import com.challenge.backend.note.domain.model.entity.Note;
import com.challenge.backend.note.domain.persistance.NoteRepository;
import com.challenge.backend.shared.exception.ResourceNotFoundException;
import com.challenge.backend.shared.exception.ResourceValidationException;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class CategoryServiceIml implements CategoryService {
    private static final String ENTITY ="Category";
    private CategoryRepository categoryRepository;
    private NoteRepository noteRepository;
    private final Validator validator;

    public CategoryServiceIml(CategoryRepository categoryRepository , NoteRepository noteRepository, Validator validator){
        this.categoryRepository = categoryRepository;
        this.noteRepository = noteRepository;
        this.validator = validator;
    }

    @Override
    public Category createCategory(Long noteId , Category request){
        Set<ConstraintViolation<Category>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw  new ResourceValidationException(ENTITY,violations);

        Note note = noteRepository.findById(noteId).orElseThrow(()->
                new ResourceNotFoundException("Note",noteId));
         note.getCategories().add(request);
         return categoryRepository.save(request);
    }

}