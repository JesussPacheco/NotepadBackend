package com.challenge.backend.category.service;

import com.challenge.backend.category.model.persistance.CategoryRepository;
import com.challenge.backend.note.domain.persistance.NoteRepository;
import org.springframework.stereotype.Service;

import javax.validation.Validator;

@Service
public class CategoryServiceIml {
    private static final String ENTITY ="Category";
    private CategoryRepository categoryRepository;
    private NoteRepository noteRepository;
    private final Validator validator;

    public CategoryServiceIml(CategoryRepository categoryRepository , NoteRepository noteRepository, Validator validator){
        this.categoryRepository = categoryRepository;
        this.noteRepository = noteRepository;
        this.validator = validator;
    }

}