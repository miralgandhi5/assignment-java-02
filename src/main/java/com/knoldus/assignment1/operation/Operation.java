package com.knoldus.assignment1.operation;
import com.knoldus.assignment1.entities.Student;
import com.knoldus.assignment1.entities.ClassRoom;
import java.util.List;
import java.util.stream.Collectors;
/**
 * defines operation to perform on list of students and classroom.
 *
 */

public class Operation {

    /**
     * retrieves list of students with no subjects associated.
     *
     * @param students list of students.
     * @return students list of students with no subjects.
     */

    public static List<Student> getStudentsWithoutSubjects(List<Student> students) {
        return students.stream().filter(student -> student.getSubject().isEmpty())
                .collect(Collectors.toList());
    }

    /**
     * retrieves list of subjects for a particular roomId.
     *
     * @param classRooms list of rooms
     * @param roomId     id of classroom
     * @return list of subjects
     */
    public static List<String> getSubjectsOfClassRoom(List<ClassRoom> classRooms, int roomId) {
        return classRooms.stream().filter(classRoom -> classRoom.getRoomID() == roomId)
                .flatMap(classRoom -> classRoom.getSubjects().stream()).collect(Collectors.toList());
    }

    /**
     * prints hello to classroom that have students associated.
     *
     * @param classRooms list of classrooms
     */

    public static List<String> printHelloToClassRoom(List<ClassRoom> classRooms) {
        return classRooms.stream().filter(classRoom -> !classRoom.getStudentList().isEmpty())
                .map(classRoom -> "hello Students").collect(Collectors.toList());
    }

}
