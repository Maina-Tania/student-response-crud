package com.example.Response;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Student1Repository extends JpaRepository<Student1 , Long> {

    Optional<Object> findByStudentName(String studentName);
}
