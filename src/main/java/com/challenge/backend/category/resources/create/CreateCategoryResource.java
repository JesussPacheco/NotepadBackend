package com.challenge.backend.category.resources.create;

import lombok.*;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
public class CreateCategoryResource {
    @NotNull
    private String name;

}