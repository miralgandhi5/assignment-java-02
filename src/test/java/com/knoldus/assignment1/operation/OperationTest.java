package com.knoldus.assignment1.operation;


import com.knoldus.assignment1.entities.ClassRoom;
import com.knoldus.assignment1.entities.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    private static List<Student> studentList;
    private static List<ClassRoom> classRoomList;
    private static Student studentOne;

    @BeforeClass
    public static void setUp() {
        List<String> subjectList1 = Collections.singletonList("English");
        List<String> subjectList2 = Arrays.asList("Maths", "Science");

        studentOne = new Student("Ram", 123, null);
        Student studentTwo = new Student("Shyam", 456, subjectList1);
        Student studentThree = new Student("John", 789, subjectList2);
        Student studentFour = new Student("David", 101, subjectList1);

        studentList = Arrays.asList(studentOne, studentTwo, studentThree, studentFour);

        ClassRoom classRoomOne = new ClassRoom(1, Collections.singletonList(studentTwo));
        ClassRoom classRoomTwo = new ClassRoom(2, Arrays.asList(studentThree, studentFour));
        classRoomList = Arrays.asList(classRoomOne, classRoomTwo);

    }


    @Test
    public void testGetStudentsWithoutSubject() {
        List<Student> actualResult = Operation.getStudentsWithoutSubjects(studentList);
        List<Student> expectedResult = Collections.singletonList(studentOne);
        assertEquals("get students without subjects functionality failed", expectedResult, actualResult);
    }

    @Test
    public void testGetSubjectsOfClassRoom() {
        List<String> actualResult = Operation.getSubjectsOfClassRoom(classRoomList, 1);
        List<String> expectedResult = Collections.singletonList("English");
        assertEquals(" get subjects of classroom functionality failed", expectedResult, actualResult);
    }

    @Test
    public void testPrintHelloToClassRoom() {
        List<String> actualResult = Operation.printHelloToClassRoom(classRoomList);
        List<String> expectedResult = Arrays.asList("hello Students", "hello Students");
        assertEquals(" print hello students to classroom functionality failed", expectedResult, actualResult);

    }

    @Test
    public void testPrintHelloToClassRoomWithEmptyList() {
        List<String> actualResult = Operation.printHelloToClassRoom(Arrays.asList(new ClassRoom(1, null), new ClassRoom(2, null)));
        List<String> expectedResult = Collections.emptyList();
        assertEquals(" print hello students to classroom functionality failed", expectedResult, actualResult);

    }
}
