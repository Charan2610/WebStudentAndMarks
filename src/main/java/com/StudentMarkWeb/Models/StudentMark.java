package com.StudentMarkWeb.Models;

public class StudentMark {

    private int id;
    private String Subject;
    private String mark;
    private String student_Id;

    public StudentMark() {
    }

    public StudentMark(int id, String subject, String mark, String student_Id) {
        this.id = id;
        Subject = subject;
        this.mark = mark;
        this.student_Id = student_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(String student_Id) {
        this.student_Id = student_Id;
    }

    @Override
    public String toString() {
        return "StudentMark{" +
                "id=" + id +
                ", Subject='" + Subject + '\'' +
                ", mark='" + mark + '\'' +
                ", student_Id='" + student_Id + '\'' +
                '}';
    }
}
