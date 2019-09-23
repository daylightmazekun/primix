package com.primix.model.exam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String content;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private MultipleChoiceQuestion multipleChoice;

    public int getId(){
        return id;
    }

    public MultipleChoiceQuestion getMultipleChoice() {
        return multipleChoice;
    }

    public void setMultipleChoice(MultipleChoiceQuestion mutipleChoice){
        this.multipleChoice = multipleChoice;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
}