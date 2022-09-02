package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Course;

import java.util.List;

@Repository
public interface CourseDAO {
    void saveCourse(Course course,Long id);
    void updateCourse(Long id, Course course);
    void deleteCourse(Long id);
    List<Course> courses(Long companyId);
    Course getCourseById(Long id);
    List<Course> getCourses();
}
