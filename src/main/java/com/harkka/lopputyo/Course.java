package com.harkka.lopputyo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {

    private String courseID;
    private String courseName;
    private String studyPoints;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course() {

    }
    public Course(String courseID) {
        this(courseID,"","");
    }
    public Course(String courseID, String courseName, String studyPoints) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.studyPoints = studyPoints;
    }


    /** setters and getters **/
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(String studyPoints) {
        this.studyPoints = studyPoints;
    }
/** for enrolling student to course **/
    public void enrollStudent(Student student){
        enrolledStudents.add(student);
    }
/** get enrorred students **/
    public List<Student> getEnrolledStudents(){
        System.out.println(enrolledStudents);
        return enrolledStudents;}
    @Override
    public String toString() {
        return "courseID=" + courseID + " // courseName=" + courseName + " // studyPoints=" + studyPoints + " //"+"\r\n";
    }
}
