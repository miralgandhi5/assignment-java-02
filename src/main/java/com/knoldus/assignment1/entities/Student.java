package com.knoldus.assignment1.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//name(String), rollNumber(int), subject(Optional<List<String>>
public class Student {
    private String name;
    private int rollNumber;
    private Optional<List<String>> subject;

    public Student(String name, int rollNumber, List<String> subject) {
        setName(name);
        setRollNumber(rollNumber);
        setSubject(subject);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    private void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public List<String> getSubject() {
        return subject.orElseGet(ArrayList::new);
    }

    private void setSubject(List<String> subject) {
        this.subject = Optional.ofNullable(subject);
    }

    @Override
    public String toString() {
        return "Student{"
                +
                "name='" + getName() + '\''
                +
                ", rollNumber=" + getRollNumber()
                +
                ", subject=" + getSubject()
                +
                '}';
    }


}
