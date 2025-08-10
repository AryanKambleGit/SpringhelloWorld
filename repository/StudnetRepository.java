package com.codingshuttle.youtube.Learning.Rest.APIs.repository;


import com.codingshuttle.youtube.Learning.Rest.APIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudnetRepository extends JpaRepository<Student, Long> {

}
