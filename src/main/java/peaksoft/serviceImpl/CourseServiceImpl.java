package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.dao.CourseDAO;
import peaksoft.model.Course;
import peaksoft.service.CourseService;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseDAO courseDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public void saveCourse(Course course, Long id) {
        courseDAO.saveCourse(course,id);
    }

    @Override
    public void updateCourse(Long id,Course course) {
        courseDAO.updateCourse(id, course);
    }


    @Override
    public void deleteCourse(Long id) {
        courseDAO.deleteCourse(id);
    }

    @Override
    public List<Course> getAllCourses(Long companyId) {
        return courseDAO.courses(companyId);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDAO.getCourseById(id);
    }

    @Override
    public List<Course> getCourses() {
        return courseDAO.getCourses();
    }
}
