package com.mbtiai.demo.qa;

import com.mbtiai.demo.pqa.Pqa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QaRepository extends JpaRepository<Qa, Long> {
}
