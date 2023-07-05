package com.numble.tossserverbatch.domain.account.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteAccountRequestDto {
    private Long id;

    @Builder
    public DeleteAccountRequestDto(Long id){
        this.id = id;
    }

}
