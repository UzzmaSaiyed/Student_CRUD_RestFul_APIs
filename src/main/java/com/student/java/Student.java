package com.student.java;

public class Student {
    private int id;
    private String name;
    private String email;
    private String mobile;
    private int age;
    private String course;

    // Constructors
    public Student() {}

    public Student(int id, String name, String email, String mobile, int age, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
        this.course = course;
    }

    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}