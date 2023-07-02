package com.numble.tossserverbatch.domain.auth.controller.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class SignInRequestDto {

    // The annotated element must not be null and must contain at least one non-whitespace character.
    @NotBlank
    private String loginId;

    @NotBlank
    private String password;


}

