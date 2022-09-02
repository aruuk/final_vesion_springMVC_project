package peaksoft.daoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.dao.StudentDAO;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveStudent(Student student, Long companyId) {
        Company company = entityManager.find(Company.class, companyId);
        company.addStudent(student);
        student.setCompany(company);
        entityManager.persist(student);

    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student student1 = entityManager.find(Student.class, id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setPhoneNumber(student.getPhoneNumber());
        student1.setStudyFormat(student.getStudyFormat());
        entityManager.merge(student1);
    }

    @Override
    public void deleteStudent(Long id) {

        entityManager.remove(entityManager.find(Student.class, id));
    }


    @Override
    public List<Student> getStudents(Long companyId) {
        return entityManager.createQuery("select s from Student s where " +
                        "s.company.id=:companyId",
                Student.class).setParameter("companyId", companyId).getResultList();
    }


    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void assignStudentToCourse(Long studentId, Long courseId) {
        Student student = entityManager.find(Student.class, studentId);
        Course course = entityManager.find(Course.class, courseId);
        student.setCourse(course);
        course.addStudent(student);
        entityManager.merge(student);
    }

    @Override
    public List<Student> countOfStudents(Long id) {
        return entityManager.createQuery("select count (Student.id) from Student s " +
                "where s.company.id = :id ", Student.class).setParameter("id",id).getResultList();

    }
}
