package com.challenge.backend.users.mapping;

import com.challenge.backend.shared.mapping.EnhancedModelMapper;
import com.challenge.backend.users.domain.model.Entity.User;
import com.challenge.backend.users.resource.UserResource;
import com.challenge.backend.users.resource.create.CreateUserResource;
import com.challenge.backend.users.resource.update.UpdateUserResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class UserMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public UserResource toResource(User model) {
        return mapper.map(model, UserResource.class);
    }

    public User toModel(CreateUserResource resource) {
        return mapper.map(resource, User.class);
    }

    public User toModel(UpdateUserResource resource) {
        return mapper.map(resource, User.class);
    }

}