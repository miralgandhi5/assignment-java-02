package com.knoldus.assignment1;

import com.knoldus.assignment1.entities.ClassRoom;
import com.knoldus.assignment1.entities.Student;
import com.knoldus.assignment1.operation.Operation;

import java.util.Arrays;
import java.util.List;

public class MyApp {
    public static void main(String[] args) {

        List<String> subjectList1 = Arrays.asList("Maths", "Science", "English");
        List<String> subjectList2 = Arrays.asList("Maths", "Science", "English", "Geography");
        List<String> subjectList3 = Arrays.asList("Maths", "Science");

        Student studentOne = new Student("Ram", 123, null);
        Student studentTwo = new Student("Shyam", 456, subjectList2);
        Student studentThree = new Student("John", 789, subjectList3);
        Student studentFour = new Student("David", 101, subjectList1);

        List<Student> studentList = Arrays.asList(studentOne, studentTwo, studentThree, studentFour);

        ClassRoom classRoomOne = new ClassRoom(1, Arrays.asList(studentOne, studentTwo));
        ClassRoom classRoomTwo = new ClassRoom(2, Arrays.asList(studentThree, studentFour));


        List<ClassRoom> classRoomList = Arrays.asList(classRoomOne, classRoomTwo);

        Operation.getStudentsWithoutSubjects(studentList).forEach(System.out::println);

        Operation.getSubjectsOfClassRoom(classRoomList, 1).forEach(System.out::println);

        Operation.printHelloToClassRoom(classRoomList).forEach(System.out::println);


    }
}
