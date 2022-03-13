package com.harkka.lopputyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    @Autowired
    FileService objFileService;
    /**list to hold students**/
    private List<Student> students = new ArrayList<>();
    /** list to hold courses **/
    private List<Course> courses = new ArrayList<>();

/** on startup read students and courses from file **/

public MainService() {
        try {
            FileService fs = new FileService();
            students = fs.readStudentsFromFile();
            courses = fs.readCoursesFromFile();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    /** add single student **/
    public String addStudents(String studentNumber,String firstName,String lastName,String adress,String phoneNumber){
        Student s = new Student(studentNumber, firstName, lastName, adress, phoneNumber);
        students.add(s);
       /** backup studentdata to file **/
        try {
            objFileService.writeStudentsToFile(students);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No data available");
        }
        return "Student "+ s.getFirstName()+" "+s.getLastName()+" added.";
    }
    /** return all students **/
    public List<Student> allStudents(){
        return students;
    }

    /** add single course **/
    public String addCourse(String courseID,String courseName,String studyPoints){
        Course c = new Course(courseID, courseName, studyPoints);
        courses.add(c);
        /** backup courses to file **/
        try {
            objFileService.writeCoursesToFile(courses);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (IndexOutOfBoundsException e) {
            System.out.println("No data available");
        }
        return "Course "+c.getCourseID()+" "+c.getCourseName()+" added.";
    }
    /** return all courses **/
    public List<Course> allCourses(){
        return courses;
    }

    /** enroll student to course **/
    public String enrollStudentToCourse(String courseID, String studentNumber){

    /** check if course and student with given ID's found, if found enroll student **/
        for (Course c : courses)
              if(c.getCourseID().equals(courseID)){
                  for (Student s : students)
                      if(s.getStudentNumber().equals(studentNumber)) {
                          c.enrollStudent(s);
                          return "Student "+s.getFirstName()+" "+s.getLastName()+" enrolled to course "+c.getCourseName()+".";
                      }
              }
        return "No such student or Course ID";
        }

    /** return all enrolled students from course **/
    public List<Student> getEnrolledStuds(String courseID){
        for (Course c : courses)
            if(c.getCourseID().equals(courseID)){
            return c.getEnrolledStudents();}
    return null;}

}

