package com.harkka.lopputyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class Controller {

    /** using mainservice class autowired **/
    @Autowired
    MainService objMainService;
    Course objCourse;
    Student objStudent;

    /** add single student **/
    @PostMapping("addstudent")
    public String addStudent(@RequestParam String studentNumber, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String adress, @RequestParam String phoneNumber){
       return objMainService.addStudents(studentNumber,firstName,lastName,adress,phoneNumber);

    }
    /** get all students **/
    @GetMapping("students")
    public List<Student> getStudents(){
        return objMainService.allStudents();
    }

    /** add single course **/
    @PostMapping("addcourse")
    public String addCourses(@RequestParam String courseID, @RequestParam String courseName, @RequestParam String studyPoints){
       return objMainService.addCourse(courseID,courseName, studyPoints);

    }
    /** get all courses **/
    @GetMapping("courses")
    public List<Course> getCourses(){
        return objMainService.allCourses();
    }

    /** enroll student to course **/
    @PostMapping("enrollstuds")
    public String enrollStuds(@RequestParam String courseID, @RequestParam String studentNumber){
        return objMainService.enrollStudentToCourse(courseID, studentNumber);
    }
    /**get all enrolled students from course **/
    @PostMapping("enrolledstudscheck")
    public List<Student> getEnrolledStudents(@RequestParam String courseID){return objMainService.getEnrolledStuds(courseID); }
}
