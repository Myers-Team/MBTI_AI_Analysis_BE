package com.mbtiai.demo.contents;


import lombok.Builder;
import lombok.Getter;

//ResponseDto는 정보를 반환해 주는 것
@Builder
@Getter
public class ContentsResponseDto {
    private String tot_con;

    public static ContentsResponseDto fromEntity(Contents contents) {
        return ContentsResponseDto.builder()
                .tot_con(contents.getTot_con())
                .build();
    }
}
