package com.challenge.backend.category.model.service;

import com.challenge.backend.category.model.entity.Category;

public interface CategoryService {
    Category createCategory(Long noteId, Category request);
}
