package com.codewithmanav.store.repository;

import com.codewithmanav.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
