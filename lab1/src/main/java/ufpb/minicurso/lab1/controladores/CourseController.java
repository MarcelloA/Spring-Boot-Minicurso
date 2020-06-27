package ufpb.minicurso.lab1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpb.minicurso.lab1.entidades.Course;
import ufpb.minicurso.lab1.servicos.CourseServices;

import java.io.IOException;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseServices courseServices;

    @PostMapping("/v1/api/disciplinas")
    public ResponseEntity<Course> setCourse(@RequestBody Course newCourse) {
        try {return new ResponseEntity<Course>(courseServices.setCourse(newCourse), HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/v1/api/disciplinas")
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<List<Course>>(courseServices.getCourse(), HttpStatus.OK);
    }

    @GetMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){
        return new ResponseEntity<Course>(courseServices.getCourse(id), HttpStatus.OK);
    }

    @PutMapping("/v1/api/disciplinas/{id}/nome")
    public ResponseEntity<Course> setCourse(@PathVariable int id, @RequestBody String nome){
        try {
            return new ResponseEntity<Course>(courseServices.setCourse(nome, id),HttpStatus.OK);
        } catch (ArrayIndexOutOfBoundsException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/v1/api/disciplinas/{id}/nota")
    public ResponseEntity<Course> setCourseScore(@PathVariable int id, @RequestBody String nota){
        try {
            return new ResponseEntity<Course>(courseServices.setCourseScore(nota, id),HttpStatus.OK);
        }catch (ArrayIndexOutOfBoundsException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/v1/api/disciplinas/{id}")
    public ResponseEntity<Course> removeCourse(@PathVariable int id){
        try {
            return new ResponseEntity<Course>(courseServices.removeCourse(id), HttpStatus.OK);
        } catch (ArrayIndexOutOfBoundsException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/v1/api/disciplinas/ranking")
    public ResponseEntity<List<Course>> sortCourses(){
        try {
            return new ResponseEntity<List<Course>>(courseServices.sortCourses(), HttpStatus.OK);
        }catch (ClassCastException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
