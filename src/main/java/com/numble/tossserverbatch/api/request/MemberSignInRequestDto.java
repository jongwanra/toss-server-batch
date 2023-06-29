package com.numble.tossserverbatch.api.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class MemberSignInRequestDto {

    @NotEmpty
    private String name;
    

}
