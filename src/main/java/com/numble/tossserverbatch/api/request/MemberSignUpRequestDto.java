package com.numble.tossserverbatch.api.request;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class MemberSignUpRequestDto {

    @NotEmpty
    private String name;

    @NotEmpty
    @Length(min = 8, max = 8)
    private String birthDay;


}
