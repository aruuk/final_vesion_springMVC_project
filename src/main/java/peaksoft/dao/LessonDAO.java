package peaksoft.dao;

import peaksoft.model.Lesson;

import java.util.List;

public interface LessonDAO {
    void saveLesson(Long courseId,Lesson lesson);
    void updateLesson(Long id, Lesson lesson);
    void deleteLesson(Long id);
    List<Lesson> getLessons(Long courseId);
    Lesson getLessonById(Long id);
}
