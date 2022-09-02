package peaksoft.dao;

import peaksoft.model.Instructor;

import java.util.List;

public interface InstructorDAO {
    void saveInstructor(Long companyId, Instructor instructor);
    void updateInstructor(Long id, Instructor instructor);
    List<Instructor> getInstructorsByCompany(Long id);
    void deleteInstructor(Long id);
    List<Instructor> getInstructors();

    List<Instructor> getInstructorsByCompanyId(Long id);
    Instructor getInstructorById(Long id);
    void getStudentsCount();
    void assignedInstructorToCourse(Long instructorId, Long courseId);
}
