package com.mbtiai.demo.repository;

import com.mbtiai.demo.common.UserType;
import com.mbtiai.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByAccount(String account);
    List<User> findAllByType(UserType type);
}
