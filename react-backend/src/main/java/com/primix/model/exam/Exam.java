package com.primix.model.exam;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exam extends Widget{

    private String title;
    private String description;

    @JsonIgnore
    private Integer points;
    @OneToMany(mappedBy = "exam")
    @JsonIgnore
    private List<Question> questions;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Integer getPoints(){
        return points;
    }

    public void setPoints(){
        this.points = points;
    }
    
    public List<Question> getQuestions(){
        return questions;
    }

    public void setQuestions(List<Question> questions){
        this.questions = questions;
    }

}