package com.datingengine.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.datingengine.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
