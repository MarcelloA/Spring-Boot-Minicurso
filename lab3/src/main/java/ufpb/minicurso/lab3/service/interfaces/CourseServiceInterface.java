package ufpb.minicurso.lab3.service.interfaces;

import ufpb.minicurso.lab3.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseServiceInterface {

    List<Course> getCourse();

    Optional<Course> getCourse(long id);

    Course setCourseLike(long id);

    Course setCourseScore(String scoreField, long id);

    Course setCourseComment(long id, String comment);

    Course removeCourse(long id);

    List<Course> sortCoursesByScore();

    List<Course> sortCoursesByLikes();
}
