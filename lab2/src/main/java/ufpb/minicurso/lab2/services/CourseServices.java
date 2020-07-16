package ufpb.minicurso.lab2.services;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufpb.minicurso.lab2.entities.Course;
import org.json.simple.JSONObject;
import ufpb.minicurso.lab2.repository.CourseRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;


@Service
public class CourseServices {


    @Autowired
    private CourseRepository courseRepository;
    private List<Course> course;
    public CourseServices(){}

    @PostConstruct
    public void initCourse(){
        if(courseRepository.count() == 96){
            return;
        } else{
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Course>> typeReference = new TypeReference<List<Course>>(){};
            InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/courses.json");
            try{
                course = mapper.readValue(inputStream, typeReference);
                this.courseRepository.saveAll(course);
                System.out.println("Courses saved on Db");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public List<Course> getCourse(){
        return courseRepository.findAll();
    }


    public Optional<Course> getCourse(long id){
        return courseRepository.findById(id);
    }

    public Course setCourseLike(long id){
        if(courseRepository.findById(id).isEmpty()) throw new NoSuchElementException();

        int numberOfLikes = getCourse(id).get().getLikes();
        getCourse(id).get().setLikes(numberOfLikes+1);

        courseRepository.save(getCourse(id).get());

        return getCourse(id).get();
    }

//    TODO: Tratar caso usuário envie nota inválida
    public Course setCourseScore(String scoreField, long id){
        if(courseRepository.findById(id).isEmpty()) throw new NoSuchElementException();

        JSONObject obj = (JSONObject) JSONValue.parse(scoreField);
        double score = (double) obj.get("score");

        getCourse(id).get().setScore(score);

        courseRepository.save(getCourse(id).get());

        return getCourse(id).get();
    }

    public Course setCourseComment(long id, String comment){
        if(courseRepository.findById(id).isEmpty()) throw new NoSuchElementException();

        JSONObject obj = (JSONObject) JSONValue.parse(comment);
        String commentary = (String) obj.get("commentary");

        String oldCommentaries = getCourse(id).get().getCommentary();
        if(oldCommentaries == null){
            getCourse(id).get().setCommentary(commentary);
        } else {
            getCourse(id).get().setCommentary(oldCommentaries + System.lineSeparator() + commentary);
        }

        courseRepository.save(getCourse(id).get());

        return getCourse(id).get();
    }

    public Course removeCourse(long id){
        if(courseRepository.findById(id).isEmpty()) throw new ArrayIndexOutOfBoundsException();

        Course deletedCourse = getCourse(id).get();
        courseRepository.deleteById(id);

        return deletedCourse;
    }

    public List<Course> sortCoursesByScore(){
        return sortCourses("score");
    }

    public List<Course> sortCoursesByLikes(){
        return sortCourses("likes");
    }

    private List<Course> sortCourses(String mode) {
        course = getCourse();
        Collections.sort(course, (o1, o2) -> {

            if(mode.equals("score")){
                if(o1.getScore() > o2.getScore()) return -1;
                if(o1.getScore() < o2.getScore()) return 1;
            } else if(mode.equals("likes")) {
                if(o1.getLikes() > o2.getLikes()) return -1;
                if(o1.getLikes() < o2.getLikes()) return 1;
            }

            return 0;
        });
        return course;
    }
}
