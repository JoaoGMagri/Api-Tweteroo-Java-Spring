package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
