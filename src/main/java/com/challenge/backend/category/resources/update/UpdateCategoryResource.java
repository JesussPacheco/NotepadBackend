package com.challenge.backend.category.resources.update;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class UpdateCategoryResource {
    @NotNull
    private String name;

}