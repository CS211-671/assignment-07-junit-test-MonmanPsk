package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s1;

    @BeforeEach
    void init() {
        s1 = new Student("6610450765", "Mon");
    }

    @Test
    @DisplayName("Name should change to new name")
    void testChangeName() {
        s1.changeName("Man");
        assertEquals("Man", s1.getName());
    }

    @Test
    @DisplayName("Score should add")
    void testAddScore() {
         s1.addScore(10.5);
         assertEquals(10.5, s1.getScore());
         s1.addScore(50);
         assertEquals(60.5, s1.getScore());
    }

    @Test
    @DisplayName("Grade should calculate correct")
    void testCalculateGrade() {
        s1.addScore(70);
        assertEquals("B", s1.grade());
    }

    @Test
    @DisplayName("Input id should equal student id")
    void testIsId() {
        assertTrue(s1.isId("6610450765"));
        assertFalse(s1.isId("66xxxxxxxx"));
    }
}