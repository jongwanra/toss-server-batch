package com.numble.tossserverbatch.domain.member.controller.dto.request;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class MemberSignUpRequestDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String name;

    @NotBlank
    @Length(min = 8, max = 8)
    private String birthDay;

    @NotBlank
    @Length(min = 8, max = 20)
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
    private String password;


}
