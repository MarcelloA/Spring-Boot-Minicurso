package ufpb.minicurso.lab1.servicos;

import org.json.simple.JSONValue;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;
import org.springframework.stereotype.Service;
import ufpb.minicurso.lab1.entidades.Course;
import org.json.simple.JSONObject;

import java.util.*;


@Service
public class CourseServices {
    private List<Course> course = new ArrayList<>();

    public Course setCourse(Course newCourse) throws IllegalArgumentException{

            if(course.isEmpty()){
                course.add(newCourse);
                return newCourse;

            } else {
                for (Course c : course) {
                    if(c.getName().contains(newCourse.getName()))
                        throw new IllegalArgumentException();
                }
                newCourse.setId(course.size());
                course.add(newCourse);
                return newCourse;
            }
        }

    public List<Course> getCourse(){
        return course;
    }

//    TODO: Tratar caso usuário envie um id inválido
    public Course getCourse(int id){
        return course.get(id);
    }

    public Course setCourse(String name, int id){
        if(id >= course.size()) throw new ArrayIndexOutOfBoundsException();

        JSONObject obj = (JSONObject) JSONValue.parse(name);
        String newName = (String) obj.get("name");

        course.get(id).setName(newName);
        return course.get(id);
    }

//    TODO: Tratar caso usuário envie nota inválida
    public Course setCourseScore(String scoreField, int id){
        if(id >= course.size()) throw new ArrayIndexOutOfBoundsException();

        JSONObject obj = (JSONObject) JSONValue.parse(scoreField);
        double score = (double) obj.get("score");

        course.get(id).setScore(score);
        return course.get(id);
    }

    public Course removeCourse(int id){
        return course.remove(id);
    }

    public List<Course> sortCourses(){
        Collections.sort(course, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                String o1Score = Double.toString(o1.getScore());
                String o2Score = Double.toString(o2.getScore());

                if(o1.getScore() > o2.getScore()) return -1;
                if(o1.getScore() < o2.getScore()) return 1;

                return 0;
            }
        });
        return course;
    }

}
