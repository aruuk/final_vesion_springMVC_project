package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.dao.InstructorDAO;
import peaksoft.model.Instructor;
import peaksoft.service.InstructorService;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class InstructorServiceImpl implements InstructorService {
    private final InstructorDAO instructorDAO;

    @Autowired
    public InstructorServiceImpl(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public void saveInstructor(Long id, Instructor instructor) {
        instructorDAO.saveInstructor(id,instructor);
    }

    @Override
    public void updateInstructor(Long id,Instructor instructor) {
        instructorDAO.updateInstructor(id, instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorDAO.deleteInstructor(id);
    }

    @Override
    public List<Instructor> getAllInstructors(Long id) {
        return instructorDAO.getInstructors();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDAO.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorsByCompanyId(Long id) {
        return instructorDAO.getInstructorsByCompany(id);
    }

    @Override
    public void getStudentsCount() {
        instructorDAO.getStudentsCount();
    }

    @Override
    public void assignedInstructorToCourse(Long instructorId, Long courseId) {
        instructorDAO.assignedInstructorToCourse(instructorId,courseId);
    }
}
