package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.dao.StudentDAO;
import peaksoft.model.Student;
import peaksoft.service.StudentService;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }


    @Override
    public void saveStudent(Student student, Long id) {
        studentDAO.saveStudent(student,id);
    }

    @Override
    public void updateStudent(Long id ,Student student) {
        studentDAO.updateStudent(id, student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDAO.deleteStudent(id);
    }

    @Override
    public List<Student> getStudents(Long id) {
        return studentDAO.getStudents(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public void assignStudentToCourse(Long studentId, Long courseId) {
        studentDAO.assignStudentToCourse(studentId,courseId);
    }

    @Override
    public List<Student> countOfStudents(Long id) {
        return studentDAO.countOfStudents(id);
    }
}
