package com.challenge.backend.users.resource.create;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
public class CreateUserResource {
    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
