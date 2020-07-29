package ufpb.minicurso.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufpb.minicurso.lab3.entity.Course;

import java.io.Serializable;

public interface CourseRepository<T, ID extends Serializable> extends JpaRepository<Course, Long> {
}
