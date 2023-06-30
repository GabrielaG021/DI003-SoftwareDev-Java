/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Gabriela Gutierrez
 */
public class ClassRosterController {
    private UserIO io = new UserIOConsoleImpl();
    // we must create a ClassRosterDao member field in our Controller so
    // we can have the DAO store the newly created Student object for us.
    private ClassRosterView view;
    private ClassRosterDao dao;
    
    public void run() {
    boolean keepGoing = true;
    int menuSelection = 0;
    try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    } catch (ClassRosterPersistenceException err) {
        view.displayErrorMessage(err.getMessage());
    }
}
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }
    
    // Method for the controller to get the menu selection that 
    // we call to get the menuSelection in the run method
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    // The view and DAO will do all the running work
    private void createStudent() throws ClassRosterPersistenceException {
        //Displays the Create Student Banner
        view.displayCreateStudentBanner();
        // Step 2: Get all the student data from the user and create the new Student object
        Student newStudent = view.getNewStudentInfo();
        // Step 3: Store the new Student object
        dao.addStudent(newStudent.getStudentId(), newStudent);
        // Step 4: Display the Create Student Success banner
        view.displayCreateSuccessBanner();
    }
    
    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    
    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
