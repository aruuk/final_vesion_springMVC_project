package peaksoft.service;

import peaksoft.model.Instructor;

import java.util.List;

public interface InstructorService {
    void saveInstructor(Long id,Instructor instructor);
    void updateInstructor(Long id, Instructor instructor);
    void deleteInstructor(Long id);
    List<Instructor> getAllInstructors(Long id);
    Instructor getInstructorById(Long id);
    List<Instructor> getInstructorsByCompanyId(Long id);
    void getStudentsCount();
    void assignedInstructorToCourse(Long instructorId, Long courseId);
}
