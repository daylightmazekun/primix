package com.primix.model.exam;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class FillInTheBlankExamQuestion extends Question {
    @Column(name = "VARIABLES", nullable = false)
    private String variables;

    public String getVariables() {
        return variables;
    }

    public void setVariables(String variables) {
        this.variables = variables;
    }

}