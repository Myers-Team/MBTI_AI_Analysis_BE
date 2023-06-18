package com.mbtiai.demo.qa;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QaResponseDto {

    private String question;
    private String answer;
    private float emd_v;
    private Long user_id;

    public static QaResponseDto fromEntity(Qa qa){
        return QaResponseDto.builder()
                .question(qa.getQuestion())
                .answer(qa.getAnswer())
                .emd_v(qa.getEmd_v())
                .user_id(qa.getUser().getUser_id())
                .build();
    }
}
