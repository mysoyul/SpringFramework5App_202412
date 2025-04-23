package mylab.student.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentJunitTest {
    @Test
    public void testCourse() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-student-di.xml");
        
        // 빈 가져오기
        Course course = context.getBean("javaCourse", Course.class);
        
        // 검증
        assertNotNull(course);
        assertEquals("C001", course.getCourseId());
        assertEquals("Java Programming", course.getCourseName());
        assertEquals(3, course.getStudents().size());
        assertEquals("김철수", course.getStudents().get(0).getName());
        assertEquals("이영희", course.getStudents().get(1).getName());
        assertEquals("박민수", course.getStudents().get(2).getName());
        
        // 평균 점수 계산 검증
        assertEquals(85.0, course.getAverageScore(), 0.001);
    }
    
    @Test
    public void testGradeService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-student-di.xml");
        
        // 빈 가져오기
        GradeService service = context.getBean("gradeService", GradeService.class);
        
        // 검증
        assertNotNull(service);
        assertNotNull(service.getCourse());
        
        // 고득점자 검증 (80점 이상)
        List<Student> highScoreStudents = service.getHighScoreStudents(80);
        assertEquals(2, highScoreStudents.size());
        
        // 학생 등급 검증
        assertEquals("B", service.calculateGrade("S001"));  // 85점 -> B
        assertEquals("A", service.calculateGrade("S002"));  // 92점 -> A
        assertEquals("C", service.calculateGrade("S003"));  // 78점 -> C
    }
}
