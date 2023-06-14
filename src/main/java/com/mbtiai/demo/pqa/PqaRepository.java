package com.mbtiai.demo.pqa;

import com.mbtiai.demo.qa.Qa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PqaRepository extends JpaRepository<Pqa, Long> {
}
