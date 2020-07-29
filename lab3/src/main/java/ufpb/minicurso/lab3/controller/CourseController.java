package ufpb.minicurso.lab3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpb.minicurso.lab3.entity.Course;
import ufpb.minicurso.lab3.service.impl.CourseService;

import java.util.List;
import java.util.NoSuchElementException;

// todo: DTO para Course
// todo: criar exceptions e controllerAdvisor

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/api/disciplinas")
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<>(courseService.getCourse(), HttpStatus.OK);
    }

    @GetMapping("/api/disciplinas/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable("id") long id){
        try{
            return new ResponseEntity<>( courseService.getCourse(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/disciplinas/likes/{id}/")
    public ResponseEntity<Course> setCourseLikes(@PathVariable("id") long id){
        try {
            return new ResponseEntity<>(courseService.setCourseLike(id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/disciplinas/nota/{id}/")
    public ResponseEntity<Course> setCourseScore(@PathVariable long id, @RequestBody String nota){
        try {
            return new ResponseEntity<>(courseService.setCourseScore(nota, id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/disciplinas/comentarios/{id}")
    public ResponseEntity<Course> setCourseComment(@PathVariable long id, @RequestBody String comentarios){
        try {
            return new ResponseEntity<>(courseService.setCourseComment(id, comentarios), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/disciplinas/{id}")
    public ResponseEntity<Course> removeCourse(@PathVariable long id){
        try {
            return new ResponseEntity<>(courseService.removeCourse(id), HttpStatus.OK);
        } catch (ArrayIndexOutOfBoundsException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/disciplinas/ranking/notas")
    public ResponseEntity<List<Course>> sortCoursesByScore(){
        try {
            return new ResponseEntity<>(courseService.sortCoursesByScore(), HttpStatus.OK);
        }catch (ClassCastException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/disciplinas/ranking/likes")
    public ResponseEntity<List<Course>> sortCoursesByLikes(){
        try {
            return new ResponseEntity<>(courseService.sortCoursesByLikes(), HttpStatus.OK);
        } catch (ClassCastException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
