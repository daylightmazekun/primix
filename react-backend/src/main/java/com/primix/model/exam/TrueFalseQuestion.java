package com.primix.model.exam;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TrueFalseQuestion extends Question {
    @Column(name = "IS_TRUE", nullable = false)
    private boolean isTrue;
    public boolean isTrue(){
        return isTrue;
    }

    public void setTrue(boolean isTrue){
        this.isTrue = isTrue; }
}