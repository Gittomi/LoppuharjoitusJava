package com.harkka.lopputyo;

import java.io.Serializable;

public class Student implements Serializable {

    private String studentNumber;
    private String firstName;
    private String lastName;
    private String adress;
    private String phoneNumber;

    public Student() {

    }
    public Student(String studentNumber){
        this(studentNumber,"","","","");
    }

    public Student(String studentNumber, String firstName, String lastName, String adress, String phoneNumber) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;




    }

    @Override
    public String toString() {
        return "studentNumber=" + studentNumber + " // firstName=" + firstName + " // lastName=" + lastName + " // adress=" + adress + " // phoneNumber=" + phoneNumber + " //"+"\r\n";
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }





}
