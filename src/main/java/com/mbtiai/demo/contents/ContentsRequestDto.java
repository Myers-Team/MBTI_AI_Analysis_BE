package com.mbtiai.demo.contents;

//먼저 spring-boot-starter-web으로 부터 Jackson라이브러리가 함께 추가
//웹에서는 JSON으로 req body, res body를 교환합니다. 따라서 JSON <-> Java Object의 과정이 필요
//이때 MappingJackson2HttpMessageConverter가 쓰임ㅎ
//@ResponseBody @RequestBody ResponseEntity<>와 같은 곳에서 쓰이며 이외에도 JSON <-> Java Object가 필요한 곳이면 사용할 수 있음

//DTO는 로직을 갖고 있지 않는 순수한 데이터 객체이며, 일반적으로 getter/setter 메서드만을 가진다. 하지만 DTO는 단순히 데이터를 옮기는 용도이기 때문에 굳이 Setter를 이용해 값을 수정할 필요가 없이, 생성자만을 사용하여 값을 할당하는 게 좋다.

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

//Client가 Controller에 요청을 보낼 때 RequestDto의 형식으로 데이터가 이동
//RequestDto는 생성 및 수정 요청하는 것
//사실상 이거는 이번플젝에서 호출될 일이 없음
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentsRequestDto {

    @NotBlank(message = "???을 입력하세요")
    private String tot_con;

    public Contents toEntity(){
        return Contents.builder()
                .tot_con(tot_con)
                .build();
    }

}
