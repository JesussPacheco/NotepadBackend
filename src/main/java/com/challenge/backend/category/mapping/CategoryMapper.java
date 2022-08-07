package com.challenge.backend.category.mapping;

import com.challenge.backend.category.model.entity.Category;
import com.challenge.backend.category.resources.CategoryResource;
import com.challenge.backend.category.resources.create.CreateCategoryResource;
import com.challenge.backend.category.resources.update.UpdateCategoryResource;
import com.challenge.backend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public CategoryResource toResource(Category model){
        return mapper.map(model,CategoryResource.class);
    }
    public Category toModel(CreateCategoryResource resource){
        return mapper.map(resource ,Category.class);
    }
    public Category toModel(UpdateCategoryResource resource){
        return   mapper.map(resource, Category.class);
    }
}