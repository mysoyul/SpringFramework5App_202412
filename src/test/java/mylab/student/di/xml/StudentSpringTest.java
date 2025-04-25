package mylab.student.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {
	@Autowired
	@Qualifier("javaCourse")
	Course course;
	
	@Resource(name="gradeService")
	GradeService service;

	//Course Bean 검증
    @Test
    public void testCourse() {        
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
    
    //GradeService 검증
    @Test
    public void testGradeService() {        
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
