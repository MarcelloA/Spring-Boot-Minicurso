package ufpb.minicurso.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufpb.minicurso.lab2.entities.Course;

import java.io.Serializable;

public interface CourseRepository<T, ID extends Serializable> extends JpaRepository<Course, Long> {
}
