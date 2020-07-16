package ufpb.minicurso.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpb.minicurso.lab2.entities.Course;
import ufpb.minicurso.lab2.services.CourseServices;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CourseController {

    @Autowired
    private CourseServices courseServices;

    @GetMapping("/api/disciplinas")
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<List<Course>>(courseServices.getCourse(), HttpStatus.OK);
    }

    @GetMapping("/api/disciplinas/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable long id){
        try{
            return new ResponseEntity<Course>( courseServices.getCourse(id).get(), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/disciplinas/likes/{id}/")
    public ResponseEntity<Course> setCourseLikes(@PathVariable long id){
        try {
            return new ResponseEntity<Course>(courseServices.setCourseLike(id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/disciplinas/nota/{id}/")
    public ResponseEntity<Course> setCourseScore(@PathVariable long id, @RequestBody String nota){
        try {
            return new ResponseEntity<Course>(courseServices.setCourseScore(nota, id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/disciplinas/comentarios/{id}")
    public ResponseEntity<Course> setCourseComment(@PathVariable long id, @RequestBody String comentarios){
        try {
            return new ResponseEntity<Course>(courseServices.setCourseComment(id, comentarios), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/disciplinas/{id}")
    public ResponseEntity<Course> removeCourse(@PathVariable long id){
        try {
            return new ResponseEntity<Course>(courseServices.removeCourse(id), HttpStatus.OK);
        } catch (ArrayIndexOutOfBoundsException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/disciplinas/ranking/notas")
    public ResponseEntity<List<Course>> sortCoursesByScore(){
        try {
            return new ResponseEntity<>(courseServices.sortCoursesByScore(), HttpStatus.OK);
        }catch (ClassCastException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/disciplinas/ranking/likes")
    public ResponseEntity<List<Course>> sortCoursesByLikes(){
        try {
            return new ResponseEntity<>(courseServices.sortCoursesByLikes(), HttpStatus.OK);
        } catch (ClassCastException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
