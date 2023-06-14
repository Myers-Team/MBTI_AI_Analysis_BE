package com.mbtiai.demo.pqa;


import com.mbtiai.demo.qa.QaResponseDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PqaResponseDto {
    private String p_question;
    private String p_answer;
    private float p_emd_v;
    private Long user_id;

    public static PqaResponseDto fromEntity(Pqa pqa){
        return PqaResponseDto.builder()
                .p_question(pqa.getP_question())
                .p_answer(pqa.getP_answer())
                .p_emd_v(pqa.getP_emd_v())
                .user_id(pqa.getUser().getUser_id())
                .build();
    }
}
