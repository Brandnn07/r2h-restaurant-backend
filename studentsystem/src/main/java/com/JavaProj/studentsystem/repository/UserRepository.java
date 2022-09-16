package com.JavaProj.studentsystem.repository;

import com.JavaProj.studentsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
