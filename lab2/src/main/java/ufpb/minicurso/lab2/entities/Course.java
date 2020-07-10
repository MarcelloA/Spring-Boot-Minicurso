package ufpb.minicurso.lab2.entities;

import javax.persistence.*;

@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double score;

    private String commentary;
    private int likes;

    public Course(){

    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String comment) {
        this.commentary = comment + "\n";
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
