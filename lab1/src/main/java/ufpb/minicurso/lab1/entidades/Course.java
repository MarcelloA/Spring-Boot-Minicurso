package ufpb.minicurso.lab1.entidades;

import java.util.ArrayList;
import java.util.Collections;

public class Course {
    private int id=0;
    private String name;
    private double score;
    private ArrayList<Course> arrayList;

    public Course(String name, double score) {
        super();
        this.id+=id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
