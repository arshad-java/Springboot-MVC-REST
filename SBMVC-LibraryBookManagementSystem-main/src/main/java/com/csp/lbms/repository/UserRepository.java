package com.csp.lbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csp.lbms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	boolean existsByUsername(String username);
}
