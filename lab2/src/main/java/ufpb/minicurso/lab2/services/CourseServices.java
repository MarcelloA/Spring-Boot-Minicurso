package ufpb.minicurso.lab2.services;

import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;
import ufpb.minicurso.lab2.entities.Course;
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

    public Course setCourse(String name, long id){
        if(id >= course.size()) throw new ArrayIndexOutOfBoundsException();

        JSONObject obj = (JSONObject) JSONValue.parse(name);
        String newName = (String) obj.get("name");

        course.get((int) id).setName(newName);
        return course.get((int) id);
    }

    public List<Course> getCourse(){
        return course;
    }

//    TODO: Tratar caso usuário envie um id inválido
    public Course getCourse(long id){
        return course.get((int) id);
    }

//    TODO: Tratar caso usuário envie nota inválida
    public Course setCourseScore(String scoreField, long id){
        if(id >= course.size()) throw new ArrayIndexOutOfBoundsException();

        JSONObject obj = (JSONObject) JSONValue.parse(scoreField);
        double score = (double) obj.get("score");

        course.get((int) id).setScore(score);
        return course.get((int) id);
    }

    public Course removeCourse(long id){
        return course.remove((int) id);
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

    public Course setLike(long id){
        Course likedCourse = course.get((int) id);
        int likeCounter = likedCourse.getLikes();
        likedCourse.setLikes(likeCounter += 1);

        return likedCourse;
    }

    public Course setComment(long id, String comment){
        Course commentedCourse = course.get((int) id);

        JSONObject obj = (JSONObject) JSONValue.parse(comment);
        String commentary = (String) obj.get("commentary");

        commentedCourse.setCommentary(commentary);

        return commentedCourse;
    }
}
