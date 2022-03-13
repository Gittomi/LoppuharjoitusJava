package com.harkka.lopputyo;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

@Service
public class FileService {

    /** write all students to file **/
    public void writeStudentsToFile(List<Student> students) throws IOException {
        File f = new File("studentData.txt");
    FileWriter fw = new FileWriter(f);
        for (int i = 0; i < students.size(); i++) {
            fw.write(students.get(i).toString());}
    fw.close();
    }
    /** write all courses to file **/
    public void writeCoursesToFile(List<Course> courses) throws IOException {
        File f = new File("courseData.txt");
        FileWriter fw = new FileWriter(f);
        for (int i = 0; i < courses.size(); i++) {
        fw.write(courses.get(i).toString());}
        fw.close();
    }
    /** read students from file **/
    public List<Student> readStudentsFromFile() throws IOException{
        List<Student> studs = new ArrayList<>();

        File f = new File("studentData.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()) {
            String readValue = sc.nextLine();
            String[] data = readValue.split(" //");

            String studNum = data[0].replace("studentNumber=","");
            String fName = data[1].replace(" firstName=", "");
            String lName = data[2].replace(" lastName=", "");
            String adress =data[3].replace(" adress=", "");
            String phoneNum = data[4].replace(" phoneNumber=", "");

            Student student = new Student(studNum,fName,lName,adress,phoneNum);
            studs.add(student);
        }
        sc.close();
        return studs;
        }
    /** read courses from file **/
    public List<Course> readCoursesFromFile() throws IOException{
        List<Course> cours = new ArrayList<>();

        File f = new File("courseData.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()) {
            String readValue = sc.nextLine();
            String[] data = readValue.split(" //");

            String cID = data[0].replace("courseID=","");
            String cName = data[1].replace(" courseName=", "");
            String cPoints = data[2].replace(" studyPoints=", "");

            Course course = new Course(cID, cName, cPoints);
            cours.add(course);
        }
        sc.close();
        return cours;
    }
    }

