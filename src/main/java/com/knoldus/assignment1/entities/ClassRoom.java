package com.knoldus.assignment1.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//roomID(int), studentList(Optional<List<Student>>
public class ClassRoom {
    private int roomID;
    private Optional<List<Student>> studentList;

    public ClassRoom(int roomID, List<Student> studentList) {
        setRoomID(roomID);
        setStudentList(studentList);
    }

    public int getRoomID() {
        return roomID;
    }

    private void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public List<Student> getStudentList() {
        return studentList.orElseGet(ArrayList::new);
    }

    private void setStudentList(List<Student> studentList) {
        this.studentList = Optional.ofNullable(studentList);
    }

    public List<String> getSubjects() {
        return getStudentList().stream().flatMap(student -> student.getSubject().stream()).collect(Collectors.toList());

    }

    @Override
    public String toString() {
        return "ClassRoom{"
                +
                "roomID=" + getRoomID()
                +
                ", studentList=" + getStudentList()
                +
                '}';
    }
}
