package ufpb.minicurso.lab3.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Course {
    @Id @GeneratedValue
    private long id;
    @JsonProperty("nome")
    private String name;
    private double score;

    private String commentary;
    private int likes;

    public Course(){
        super();
    }

    public Course(long id, String name, double score, String commentary, int likes) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.commentary = commentary;
        this.likes = likes;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String comment) {
        this.commentary = comment;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
