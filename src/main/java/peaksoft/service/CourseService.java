package peaksoft.service;

import peaksoft.model.Company;
import peaksoft.model.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course, Long id);
    void updateCourse(Long id, Course course);
    void deleteCourse(Long id);
    List<Course> getAllCourses(Long companyId);
    Course getCourseById(Long id);
    List<Course> getCourses();
}