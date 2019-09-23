package com.primix.model.exam;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private Course course;
    @OneToMany(mappedBy = "module")
    @JsonIgnore
    private List<Lesson> lessons;

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public List<Lesson> getLessons(){
        return lessons;
    }

    public void setLessons(){
        this.lessons = lessons;
    }
}
