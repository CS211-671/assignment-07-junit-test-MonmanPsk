package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList students;

    @BeforeEach
    void init() {
        students = new StudentList();
    }

    @Test
    @DisplayName("Student list size should increase when add new student")
    void testAddNewStudent() {
        students.addNewStudent("01", "Kantachad");
        assertFalse(students.getStudents().isEmpty());
        assertEquals(0, students.findStudentById("01").getScore());
        students.addNewStudent("02", "Monman", 50);
        assertEquals(2, students.getStudents().size());
        assertEquals(50, students.findStudentById("02").getScore());
    }

    @Test
    void testFindStudentById() {
        students.addNewStudent("01", "Kantachad");
        assertNotNull(students.findStudentById("01"));
        assertEquals("01", students.findStudentById("01").getId());
        assertEquals("Kantachad", students.findStudentById("01").getName());
        assertNull(students.findStudentById("00"));
    }

    @Test
    void testGiveScoreToId() {
        students.addNewStudent("01", "Kantachad", 20);
        students.giveScoreToId("01", 45);
        assertEquals(65, students.findStudentById("01").getScore());
    }

    @Test
    void testViewGradeOfId() {
        students.addNewStudent("01", "Kantachad", 80);
        assertEquals("A", students.viewGradeOfId("01"));
        assertNull(students.viewGradeOfId("02"));
    }
}