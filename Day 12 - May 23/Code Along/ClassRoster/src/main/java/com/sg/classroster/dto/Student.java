/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classroster.dto;

/**
 *
 * @author Gabriela Gutierrez
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    // Programming Language + cohort month/year
    private String cohort;
    
    // other fields on the Student class are read/write and must be set 
    //manually after a Student object has been instantiated.
    
    
    // studentId is a read-only field. It is passed in as a parameter 
    // to the constructor, and there is no setter for this field.
    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
}
