package com.mbtiai.demo.contents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor //비권장이지만 없으면 오류
@Table(name = "contents")
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contents_id", unique = true, nullable = false)
    private Long contents_id;
}
