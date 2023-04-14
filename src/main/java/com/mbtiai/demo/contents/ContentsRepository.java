package com.mbtiai.demo.contents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Long> {
}
