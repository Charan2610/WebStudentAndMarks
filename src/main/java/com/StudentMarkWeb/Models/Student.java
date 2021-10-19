package com.StudentMarkWeb.Models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
     int id;
     @NotNull(message = "Username can not empty")
     @Size(min = 3,max = 5,message = "Name must be between 3-5 characters")
     String name;
     String age;
     String rollNo;
     String gender;


    public Student(String name, String age, String rollNo, String gender) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.gender = gender;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
