package peaksoft.daoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.dao.CourseDAO;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.model.Instructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCourse(Course course, Long id) {
        Company company = entityManager.find(Company.class, id);
        company.addCourse(course);
        course.setCompany(company);
        entityManager.merge(course);
    }


    @Override
    public void updateCourse(Long id, Course course) {
        Course course1 = entityManager.find(Course.class, id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        course1.setDescription(course.getDescription());
        course1.setDateOfStart(course.getDateOfStart());
        entityManager.merge(course1);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = entityManager.find(Course.class, id);
        for (Instructor c : course.getInstructors()) {
            c.setCourses(null);
        }
        course.setCompany(null);

        entityManager.remove(course);
    }



    @Override
    public List<Course> courses(Long companyId) {
        return entityManager.createQuery("select c from Course c where " +
                        "c.company.id=:companyId", Course.class)
                .setParameter("companyId", companyId).getResultList();
    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> getCourses() {
        return entityManager.createQuery("select c from Course c",
                Course.class).getResultList();
    }
}
