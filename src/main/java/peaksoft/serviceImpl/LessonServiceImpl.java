package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.dao.LessonDAO;
import peaksoft.model.Lesson;
import peaksoft.service.LessonService;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class LessonServiceImpl implements LessonService {
    private final LessonDAO lessonDAO;

    @Autowired
    public LessonServiceImpl(LessonDAO lessonDAO) {
        this.lessonDAO = lessonDAO;
    }

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        lessonDAO.saveLesson(courseId,lesson);
    }

    @Override
    public void updateLesson(Long id,Lesson lesson) {
        lessonDAO.updateLesson(id, lesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonDAO.deleteLesson(id);
    }

    @Override
    public List<Lesson> getLessons(Long id) {
        return lessonDAO.getLessons(id);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonDAO.getLessonById(id);
    }
}
